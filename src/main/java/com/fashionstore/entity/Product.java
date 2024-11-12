package com.fashionstore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String nameProduct;
    private Long price;

    @Temporal(TemporalType.DATE)
    private Date publicationDate;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String image;
    private int stock;
    private boolean isDelete;
    private String size;
    private String color;
    private boolean gender;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;



    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;
}
