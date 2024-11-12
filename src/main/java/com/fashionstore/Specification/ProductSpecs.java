package com.fashionstore.Specification;

import org.springframework.data.jpa.domain.Specification;

import com.fashionstore.entity.Product;

public class ProductSpecs {
	public static Specification<Product> hasIdCategory(String idCategory) {
        return (root, query, criteriaBuilder) -> {
            try {
                Integer categoryId = idCategory == null ? null : Integer.parseInt(idCategory);
                if (categoryId != null) {
                    return criteriaBuilder.equal(root.join("category").get("idCategory"), categoryId);
                }
                System.out.println("cate null");
                return null;
            } catch (Exception e) {
                throw new RuntimeException("Invalid_id_Category");
            }

        };

    }

    public static Specification<Product> hasNameProduct(String keyword) {
        return (root, query, criteriaBuilder) -> {
            if (keyword != null) {
                return criteriaBuilder.like(root.get("nameFood"), "%" + keyword + "%");
            }
            System.out.println("name null");
            return null;
        };
    }

    public static Specification<Product> isGender(String isGender) {
        return (root, query, criteriaBuilder) ->{
         if(isGender!=null){

             return criteriaBuilder.equal(root.get("isGender"), Boolean.valueOf(isGender));
         }
            System.out.println("selling null");
            return null;
        };

    }
    
    public static Specification<Product> hasPrice(String price) {
        return (root, query, criteriaBuilder) -> {
            try {
            	Long Price = price == null ? null : Long.parseLong(price);
                if (Price != null) {
                    return criteriaBuilder.equal(root.get("price"), Price);
                }
                System.out.println("prsice null");
                return null;
            } catch (Exception e) {
                throw new RuntimeException("Invalid_id_Price");
            }

        };

    }

}
