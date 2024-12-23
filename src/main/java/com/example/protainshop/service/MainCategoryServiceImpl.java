package com.example.protainshop.service;


import com.example.protainshop.dto.MainCategoryDTO;
import com.example.protainshop.dto.SubCategoryDTO;
import com.example.protainshop.entity.MainCategory;
import com.example.protainshop.entity.SubCategory;
import com.example.protainshop.repository.MainCategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor


public class MainCategoryServiceImpl implements MainCategoryService {
    private final MainCategoryRepository mainCategoryRepository;

    @Transactional(readOnly = true)
    @Override
    public MainCategoryDTO getMainCategoryById( Long id) {
        return mainCategoryRepository.findByIdWithSubCategory(id)
                .map(this::toDTO)
                .orElseThrow(()-> new IllegalArgumentException("아이디를 찾을 수 없습니다"));
    }

    @Transactional(readOnly = true)
    @Override
    public List<MainCategoryDTO> findAll() {
      return mainCategoryRepository.findAll().stream()
              .map(this::toDTO)
              .toList();

    }


    private MainCategoryDTO toDTO(MainCategory mainCategory) {
        return MainCategoryDTO.builder()
                .id(mainCategory.getId())
                .name(mainCategory.getName())
                .subCategories(mainCategory.getSubCategories().stream()
                        .map(this::toDTO) // SubCategory를 SubCategoryDTO로 변환
                        .toList())
                .build();
    }

    private SubCategoryDTO toDTO(SubCategory subCategory) {
        return SubCategoryDTO.builder()
                .id(subCategory.getId())
                .name(subCategory.getName())
                .build();
    }
}
