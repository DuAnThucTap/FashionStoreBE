package com.fashionstore.respone;

import com.fashionstore.request.CategoryDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponeDTO {
	private Long categoryId;
	private String nameCategory;
}
