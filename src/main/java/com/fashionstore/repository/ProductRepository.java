package com.fashionstore.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fashionstore.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	Page<Product> findAll(Specification<Product> spec, Pageable pageable);
	Product findByNameProduct(String nameProduct);

}

