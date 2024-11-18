package com.fashionstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashionstore.entity.Category;
import com.fashionstore.repository.CategoryRepository;
import com.fashionstore.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return  categoryRepository.findAll();
    }
	@Override
	public Category findByidCategory(int id) {
		return categoryRepository.findById(id).orElse(null);
	}

    


}
