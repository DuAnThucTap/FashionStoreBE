package com.fashionstore.service;

import java.util.List;

import com.fashionstore.entity.Category;

public interface CategoryService {
    public List<Category> findAll();
    public Category findByidCategory(int id);
}

