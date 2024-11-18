package com.fashionstore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long productId;

    String nameProduct;
    Long price;

    @Temporal(TemporalType.DATE)
    Date publicationDate;

    @Column(columnDefinition = "TEXT")
    String description;

    String image;
    int stock;
    boolean isDelete;
    String size;
    String color;
    boolean gender;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_category")
	@Fetch(FetchMode.JOIN)
    Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    List<OrderDetail> orderDetails;
}

