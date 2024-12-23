package com.example.protainshop.repository;

import com.example.protainshop.dto.MainCategoryDTO;
import com.example.protainshop.entity.MainCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface MainCategoryRepository extends JpaRepository<MainCategory, Long> {

@Query("SELECT mc FROM MainCategory mc JOIN FETCH mc.subCategories WHERE mc.id=:id")
    Optional<MainCategory> findByIdWithSubCategory(@Param("id") Long id);
}
