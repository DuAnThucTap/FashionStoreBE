package com.fashionstore.map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.fashionstore.entity.Product;
import com.fashionstore.request.ProductDTO;
import com.fashionstore.respone.ProductResponeDTO;

@Component
public class FoodMapper {
    public Product toProductDTO(ProductDTO requestDTO) {
        Product dto = new Product();
        BeanUtils.copyProperties(requestDTO, dto);
        return dto;
    }
    public ProductResponeDTO toProductResponeDTO(Product product) {
        ProductResponeDTO dto = new ProductResponeDTO();
        BeanUtils.copyProperties(product, dto);
        return dto;
    }
}