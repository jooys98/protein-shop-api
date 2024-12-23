package com.example.protainshop.repository;

import com.example.protainshop.entity.Product;
import com.example.protainshop.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long>{
    // 서브 카테고리 ID별로 관련된 Product 리스트 가져오기
    @Query("SELECT p FROM Product p WHERE p.subCategoryProduct.id = :id")
    List<Product> findProductsBySubCategoryId(@Param("id") Long subCategoryId);

    // 필요하다면 SubCategory와 함께 Products를 페치 조인으로 가져오는 메서드도 구현 가능
    @Query("SELECT sc FROM SubCategory sc JOIN FETCH sc.products WHERE sc.id = :id")
    Optional<SubCategory> findByIdWithProducts(@Param("id") Long subCategoryId);
}
