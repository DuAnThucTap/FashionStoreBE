package com.fashionstore.map;

import com.fashionstore.entity.Product;
import com.fashionstore.request.ProductDTO;
import com.fashionstore.respone.ProductResponeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper{
     Product toProductDTO(ProductDTO requestDTO);
     @Mapping(source = "category.idCategory",target = "idCategory")
     ProductResponeDTO toProductResponeDTO(Product product) ;
}