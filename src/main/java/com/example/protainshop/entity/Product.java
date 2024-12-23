package com.example.protainshop.entity;


import jakarta.persistence.*;
import jdk.jfr.Category;
import lombok.*;

@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_tbl")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int price;
    private String description;
    @Column(name = "img_src")
    private String imagesrc;
    private String mainCategory;
    private String subCategory;
    private Long mainCategoryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sub_category_id" , insertable = false, updatable = false)
    private SubCategory subCategoryProduct;

}
