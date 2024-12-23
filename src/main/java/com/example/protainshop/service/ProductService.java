package com.example.protainshop.service;

import com.example.protainshop.dto.PageResponse;
import com.example.protainshop.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
//    List<ProductDTO> findAll();
    ProductDTO findById(Long id);
    PageResponse<ProductDTO> findAll(Pageable pageable);
Page<ProductDTO> searchByTitle(String keyword, Pageable pageable);
}
//전체상품 보기
//아이디 별 상품 상세 조회
// 장바구니에 담기