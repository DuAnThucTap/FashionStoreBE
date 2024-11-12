package com.fashionstore.Specification;

import com.fashionstore.entity.Customer;
import org.springframework.data.jpa.domain.Specification;

public class CustomerSpecs {
    public static Specification<Customer> hasNameCustomer(String keyword) {
        return (root, query, criteriaBuilder) -> {
            if (keyword != null) {
                return criteriaBuilder.like(root.get("fullname"), "%" + keyword + "%");
            }
            System.out.println("fullname null");
            return null;
        };
    }

    public static Specification<Customer> hasEmail(String keyword) {
        return (root, query, criteriaBuilder) -> {
            if (keyword != null) {
                return criteriaBuilder.like(root.get("email"), "%" + keyword + "%");
            }
            System.out.println("email null");
            return null;
        };
    }

    public static Specification<Customer> hasPhoneNumber(String keyword) {
        return (root, query, criteriaBuilder) -> {
            if (keyword != null) {
                return criteriaBuilder.like(root.get("phoneNumber"), "%" + keyword + "%");
            }
            System.out.println("phoneNumber null");
            return null;
        };
    }

    public static Specification<Customer> hasAddress(String keyword) {
        return (root, query, criteriaBuilder) -> {
            if (keyword != null) {
                return criteriaBuilder.like(root.get("address"), "%" + keyword + "%");
            }
            System.out.println("address null");
            return null;
        };
    }
}
