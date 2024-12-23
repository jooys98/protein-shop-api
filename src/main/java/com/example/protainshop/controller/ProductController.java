package com.example.protainshop.controller;


import com.example.protainshop.dto.PageResponse;
import com.example.protainshop.dto.ProductDTO;
import com.example.protainshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/protain")
@RequiredArgsConstructor


public class ProductController {
    private final ProductService productService;

//    @GetMapping
//    public List<ProductDTO> getProducts() {
//        return productService.findAll();
//    } //원래 있던 상품 전체 목록 read 기능

    @GetMapping
    public PageResponse<ProductDTO> getProducts(
            @PageableDefault(size = 12) Pageable pageable) {
//sort = "id", direction = Sort.Direction.ASC
// sort = "id": 어떤 필드를 기준으로 정렬할지 지정 (여기서는 id 필드 기준)
//direction = Sort.Direction.DESC: 정렬 방향 지정
//DESC: 내림차순 (큰 수에서 작은 수로)
//ASC: 오름차순 (작은 수에서 큰 수로)
        //최신 상품부터 보여주고 싶을 때 (id DESC)
        //가격순으로 정렬하고 싶을 때 (price ASC/DESC)
        //이름순으로 정렬하고 싶을 때 (name ASC/DESC)
        return productService.findAll(pageable);

    }

    //상품 아이디별 상세조회
    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping("/search")
    public Page<ProductDTO> searchProducts(
            @RequestParam("keyword") String keyword,
            @PageableDefault(size = 12) Pageable pageable
    ){
        return productService.searchByTitle(keyword, pageable);
    }

}
