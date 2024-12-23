package com.example.protainshop.dto;


import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDTO {
private Long id;
private String title;
private int price;
private String description;
private String imagesrc;
private String mainCategory;
private String subCategory;
}
