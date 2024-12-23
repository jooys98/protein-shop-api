package com.example.protainshop.dto;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class MainCategoryDTO {
private Long id;
private String name;
private List<SubCategoryDTO> subCategories;
}
