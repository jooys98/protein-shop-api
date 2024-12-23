package com.example.protainshop.repository;

import com.example.protainshop.dto.ProductDTO;
import com.example.protainshop.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
Page<Product> findByTitleContaining(String keyword, Pageable pageable);
}
//Repository는 항상 엔티티를 반환(dto x)
//Repository는 데이터베이스와 직접 상호작용하는 계층이므로 엔티티를 다루고, Service 계층에서 엔티티를 DTO로 변환하는 구조

