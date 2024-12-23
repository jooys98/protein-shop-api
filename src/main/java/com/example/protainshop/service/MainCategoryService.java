package com.example.protainshop.service;

import com.example.protainshop.dto.MainCategoryDTO;

import java.util.List;

public interface MainCategoryService {
    List<MainCategoryDTO> findAll();

    MainCategoryDTO getMainCategoryById(Long id);
}
