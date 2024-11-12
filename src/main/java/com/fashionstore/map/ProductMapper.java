package com.fashionstore.map;

import com.fashionstore.entity.Product;
import com.fashionstore.request.ProductDTO;
import com.fashionstore.respone.ProductResponeDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper{
     Product toProductDTO(ProductDTO requestDTO);
     ProductResponeDTO toProductResponeDTO(Product product) ;
}