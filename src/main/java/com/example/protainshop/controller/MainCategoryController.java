package com.example.protainshop.controller;


import com.example.protainshop.dto.MainCategoryDTO;
import com.example.protainshop.entity.MainCategory;
import com.example.protainshop.service.MainCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/main-category")
@RequiredArgsConstructor

public class MainCategoryController {
    private final MainCategoryService mainCategoryService;



    @GetMapping
    public List<MainCategoryDTO> getAllCategories() {
        return mainCategoryService.findAll();
    }

//    @GetMapping("/{id}")
//    public MainCategoryDTO getCategoryById(@PathVariable Long id) {
//        return mainCategoryService.findById(id);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<MainCategoryDTO>getMainCategoryById(@PathVariable Long id) {
        MainCategoryDTO mainCategoryDTO = mainCategoryService.getMainCategoryById(id);
        return ResponseEntity.ok(mainCategoryDTO);
    }
    //메인 카테고리 별 서브 카테고리 보여주기
}
