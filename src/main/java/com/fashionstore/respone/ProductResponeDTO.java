package com.fashionstore.respone;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor @NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponeDTO {
    private Long productId;
    private String nameProduct;
    private Double price;
    private String publicationDate;
    private String description;
    private String size;
    private String color;
    private String image;
    private Long categoryId; 


}
