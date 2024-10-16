package com.fashionstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fashionstore.repository.ProductRepository;
import com.fashionstore.request.ProductDTO;
import com.fashionstore.respone.ApiRespone;
import com.fashionstore.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin("http://localhost:4200")
public class ProductController {
	@Autowired
	private ProductRepository productRepository;

	 @Autowired
	    private ProductService productService;

	    @GetMapping
	    public ApiRespone<?> getAllFoods(@RequestParam(required = false, defaultValue = "0") int page,
	                                     @RequestParam(required = false, defaultValue = "20") int size  ) {
	         return ApiRespone.builder()
	                .result(productService.getAllProduct(page,size))
	                .build();
	    }
	    @GetMapping("{productId}")
	    public ApiRespone<?> getProductById(@PathVariable("productId") Long productId) {
	        return ApiRespone.builder()
	                .result(productService.getProductById(productId))
	                .build();
	    }
	    @PostMapping
	    public ApiRespone<?> postProduct(@ModelAttribute @Valid ProductDTO requestDTO, @RequestParam(name = "file",required = false) MultipartFile file  ) {
	        return ApiRespone.builder()
	                .result(productService.saveProduct(requestDTO,file))
	                .build();

	    }
	    @PutMapping("/{id}")
	    public ApiRespone<?> putProduct(@PathVariable("id") Long productId ,@ModelAttribute @Valid ProductDTO requestDTO, @RequestParam(name = "file",required = false) MultipartFile file  ) {
	        return ApiRespone.builder()
	                .result(productService.updateProduct(productId,requestDTO,file))
	                .build();
	    }
	
		@DeleteMapping("/{id}")
		public void deleteUser(@PathVariable Long id) {
			productRepository.deleteById(id);
		}
}
