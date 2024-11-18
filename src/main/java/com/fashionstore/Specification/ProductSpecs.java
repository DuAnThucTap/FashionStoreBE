package com.fashionstore.Specification;

import org.springframework.data.jpa.domain.Specification;

import com.fashionstore.entity.Product;



public class ProductSpecs {

    public static Specification<Product> hasNameProduct(String nameProduct) {
        return (root, query, criteriaBuilder) -> {
            if (nameProduct != null && !nameProduct.isEmpty()) {
                return criteriaBuilder.like(root.get("nameProduct"), "%" + nameProduct + "%");
            }
            return null;
        };
    }

    public static Specification<Product> hasIdCategory(String idCategory) {
        return (root, query, criteriaBuilder) -> {
            if (idCategory == null || idCategory.isEmpty()) {
                return null; 
            }
            try {
            	Integer categoryId = idCategory == null ? null : Integer.parseInt(idCategory);
                return criteriaBuilder.equal(root.join("category").get("idCategory"), categoryId);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid idCategory format: " + idCategory);
            }
        };
    }


    public static Specification<Product> hasPrice(String price) {
        return (root, query, criteriaBuilder) -> {
            if (price != null && !price.isEmpty()) {
                try {
                    Long parsedPrice = Long.parseLong(price);
                    return criteriaBuilder.equal(root.get("price"), parsedPrice);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid price: " + price);
                }
            }
            return null;
        };
    }

    public static Specification<Product> isGender(String isGender) {
        return (root, query, criteriaBuilder) -> {
            if (isGender != null && !isGender.isEmpty()) {
                try {
                    Boolean gender = Boolean.parseBoolean(isGender);
                    return criteriaBuilder.equal(root.get("gender"), gender);
                } catch (Exception e) {
                    throw new IllegalArgumentException("Invalid isGender: " + isGender);
                }
            }
            return null;
        };
    }
}

