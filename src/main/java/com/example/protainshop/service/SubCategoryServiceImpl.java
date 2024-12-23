package com.example.protainshop.service;

import com.example.protainshop.dto.ProductDTO;
import com.example.protainshop.dto.SubCategoryDTO;
import com.example.protainshop.entity.Product;
import com.example.protainshop.entity.SubCategory;
import com.example.protainshop.repository.ProductRepository;
import com.example.protainshop.repository.SubCategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class SubCategoryServiceImpl implements SubCategoryService {
    private final SubCategoryRepository subCategoryRepository;
    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    @Override

    public List<SubCategoryDTO> findAll() {
        return subCategoryRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }



    @Transactional(readOnly = true)
    @Override
    public List<ProductDTO> getProductBySubCategoryId(Long subCategoryId){
        List<Product> products = subCategoryRepository.findProductsBySubCategoryId(subCategoryId);

    if(products.isEmpty()){
        throw new IllegalArgumentException("Sub category does not exist");
    }
    return products.stream()
            .map(this::ToDTO)
            .toList();
    }

    public SubCategoryDTO toDTO(SubCategory subCategory) {
        return SubCategoryDTO.builder()
                .id(subCategory.getId())
                .name(subCategory.getName())
                .build();
    }

//    @Transactional(readOnly = true)
//    @Override
//    public List<ProductDTO> getProductsBySubCategoryId(Long subCategoryId){
//        Optional<SubCategory> subCategory = subCategoryRepository.findByIdWithProducts(subCategoryId);
//
//        if (subCategory.isEmpty()) {
//            throw new IllegalArgumentException("해당 카테고리에 상품이 존재하지 않습니다!");
//        }
//
//        return subCategory.get().getProducts()
//                .stream()
//                .map(this::ToDTO)
//                .toList();
//
//    }

    public ProductDTO ToDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .title(product.getTitle())
                .price(product.getPrice())
                .imagesrc(product.getImagesrc())
                .build();
    }


}
