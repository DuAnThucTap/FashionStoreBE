package com.fashionstore.request;

import lombok.*;

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
    private Double price;
    private String publicationDate;
    private String description;
    @NotBlank(message = "size_food_not_blank")
    private String size;
    @NotBlank(message = "color_food_not_blank")
    private String color;
    @NotBlank(message = "image_food_not_blank")
    private String image;
    @NotNull(message = "Id_category_not_null")
    private Long categoryId;

}
