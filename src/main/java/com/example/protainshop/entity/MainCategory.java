package com.example.protainshop.entity;


import com.example.protainshop.dto.SubCategoryDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "main_category_tbl")

public class MainCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "mainCategory" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<SubCategory> subCategories = new ArrayList<>();
}
//@onetomany는 dto가 아닌 entity로 정의해야함
//@onetomany : one : 부모 // many : 자식
//mappedBy = "main_category_id"  : 자식 entity 에서 연관관계를 설정힌 필드 이름
//cascade = CascadeType.ALL: 부모 엔티티에 대한 작업(예: 저장, 삭제)을 자식에게 전파
//orphanRemoval = true: 부모와의 연관관계를 끊으면 자식 데이터를 삭제
