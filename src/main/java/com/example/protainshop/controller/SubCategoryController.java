package com.example.protainshop.controller;

import com.example.protainshop.dto.ProductDTO;
import com.example.protainshop.dto.SubCategoryDTO;
import com.example.protainshop.entity.SubCategory;
import com.example.protainshop.service.ProductService;
import com.example.protainshop.service.SubCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sub-category")
@Slf4j
@RequiredArgsConstructor

public class SubCategoryController {
    private final SubCategoryService subCategoryService;


    @GetMapping
    public List<SubCategoryDTO> getAllSubCategories() {
        return subCategoryService.findAll();
    }


//    @GetMapping("/{id}/products")
//    public ResponseEntity<List<ProductDTO>> getProductsByProductId(@PathVariable Long id) {
//        List<ProductDTO> products = productService.findBySubCategoryId(id);
//        return ResponseEntity.ok(products);
//    }

    @GetMapping("/{id}/product")
  public ResponseEntity<List<ProductDTO>> getProductById(@PathVariable Long id) {
    List<ProductDTO> products = subCategoryService.getProductBySubCategoryId(id);
    return ResponseEntity.ok(products);
    }
}
