package com.fashionstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fashionstore.respone.ApiRespone;
import com.fashionstore.service.CategoryService;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ApiRespone<?> getAllCategories() {
        return ApiRespone.builder()
                .result(categoryService.findAll())
                .build();
    }

}