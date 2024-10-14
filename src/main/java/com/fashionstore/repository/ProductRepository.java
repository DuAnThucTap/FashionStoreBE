package com.fashionstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.fashionstore.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {


}

