package com.example.protainshop.dto;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SubCategoryDTO {
    private Long id;
    private String name;
    private List<ProductDTO> products;
}
