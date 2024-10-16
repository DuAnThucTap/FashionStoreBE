package com.fashionstore.service;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.fashionstore.request.ProductDTO;
import com.fashionstore.respone.ProductResponeDTO;

public interface ProductService {
	 public Page<ProductResponeDTO> getAllProduct(int page, int size);
	 public ProductResponeDTO saveProduct(ProductDTO requestDTO, MultipartFile file);
	 public ProductResponeDTO updateProduct(Long productId,ProductDTO requestDTO, MultipartFile file);
	 public ProductResponeDTO getProductById(Long productId);
}
