package com.fashionstore.service.impl;

import com.fashionstore.entity.Category;
import com.fashionstore.entity.Product;
import com.fashionstore.map.FoodMapper;
import com.fashionstore.repository.CategoryRepository;
import com.fashionstore.repository.ProductRepository;
import com.fashionstore.request.ProductDTO;
import com.fashionstore.respone.ProductResponeDTO;
import com.fashionstore.service.FileService;
import com.fashionstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private FileService fileService;
    @Autowired
    private FoodMapper foodMapper;

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Page<ProductResponeDTO> getAllProduct(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findAll(pageable).map(foodMapper::toProductResponeDTO);
    }
    @Transactional
	@Override
	public ProductResponeDTO saveProduct(ProductDTO requestDTO, MultipartFile file) {
    	Product product = productRepository.findByNameProduct(requestDTO.getNameProduct().trim());
        Category categoryProduct = categoryRepository.findById(requestDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category_not_found"));
        if (product != null) {
            throw new RuntimeException("PRODUCT_ALREADY_EXISTS");
        }
        product = foodMapper.toProductDTO(requestDTO);
        if (file != null) {
            product.setImage(file.getOriginalFilename());
            fileService.saveFile(file);
        }
        product.setCategory(categoryProduct);

        return foodMapper.toProductResponeDTO(productRepository.save(product));
		
	}
    @Transactional
	@Override
	public ProductResponeDTO updateProduct(Long productId, ProductDTO requestDTO, MultipartFile file) {
    	 Category categoryProduct= categoryRepository.findById(requestDTO.getCategoryId())
                 .orElseThrow(() -> new RuntimeException("Category_not_found"));
         Product product = productRepository.findById(productId)
                 .orElseThrow(() -> new RuntimeException("FOOD_NOT_EXISTS"));
         String imgProductTemp = product.getImage();

         product = foodMapper.toProductDTO(requestDTO);

         if (file != null && !file.getOriginalFilename().trim().equals("")) {
             imgProductTemp = file.getOriginalFilename();
             fileService.saveFile(file);
         }
         product.setCategory(categoryProduct);
         product.setProductId(productId);
         product.setImage(imgProductTemp);
         productRepository.save(product);

         return foodMapper.toProductResponeDTO(product);
	}
	@Override
	public ProductResponeDTO getProductById(Long productId) {
		Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException(" PRODUCT_NOT_EXISTS"));
        ProductResponeDTO responeDTO = foodMapper.toProductResponeDTO(product);
        responeDTO.setCategoryId(product.getCategory().getCategoryId());
        return responeDTO;
	}

}
