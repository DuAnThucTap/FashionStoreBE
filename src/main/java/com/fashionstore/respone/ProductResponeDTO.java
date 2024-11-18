package com.fashionstore.respone;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponeDTO {
    Long productId;
    String nameProduct;
    Long price;
    String publicationDate;
    String description;
    String size;
    String color;
    String image;
    Boolean gender;
    Integer idCategory;
}

