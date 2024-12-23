package com.example.protainshop.service;

import com.example.protainshop.dto.ProductDTO;
import com.example.protainshop.dto.SubCategoryDTO;

import java.util.List;

public interface SubCategoryService {
List<SubCategoryDTO> findAll();
//SubCategoryDTO findById(Long id);
List<ProductDTO> getProductBySubCategoryId(Long subCategoryId);
}
