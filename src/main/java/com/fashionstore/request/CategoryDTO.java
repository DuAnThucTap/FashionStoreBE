package com.fashionstore.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
	private Long categoryId;
	@NotBlank(message = "Name_not_blank")
	private String nameCategory;
}
