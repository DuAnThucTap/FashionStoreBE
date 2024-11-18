package com.fashionstore.request;

import lombok.*;

import java.util.Date;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long productId;
    @NotBlank(message = "Name_not_blank")
    private String nameProduct;
    @NotNull(message = "Price_not_null")
    @Min(value = 0, message = "Price_food_not_negative")
    private Long price;
    private Date publicationDate;
    private String description;
    @NotBlank(message = "size_food_not_blank")
    private String size;
    @NotBlank(message = "color_food_not_blank")
    private Boolean gender;
    private String color;
    @NotBlank(message = "image_food_not_blank")
    private String image;
    private Boolean isDelete;
    @NotNull(message = "Id_category_not_null")
    private Integer idCategory;

}
