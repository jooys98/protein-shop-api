package com.example.protainshop.service;


import com.example.protainshop.dto.PageResponse;
import com.example.protainshop.dto.ProductDTO;
import com.example.protainshop.entity.Product;
import com.example.protainshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor

public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;



//    @Transactional(readOnly = true)
//    @Override
//    public List<ProductDTO> findAll() {
//        return productRepository.findAll().stream()
//                .map(this::toDTO)
//                .toList();
//    }

    @Transactional(readOnly = true)
    @Override
    public ProductDTO findById(Long id) {
        return productRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품입니다"));
    }


    private ProductDTO toDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .title(product.getTitle())
                .price(product.getPrice())
                .description(product.getDescription())
                .imagesrc(product.getImagesrc())
                .mainCategory(product.getMainCategory())
                .subCategory(product.getSubCategory())
                .build();
    }


@Transactional(readOnly = true)
    @Override
    public PageResponse<ProductDTO> findAll(Pageable pageable){
    Page<ProductDTO> productPage = productRepository.findAll(pageable)
            .map(this::toDTO);
    return new PageResponse<>(productPage);

}

@Transactional(readOnly = true)
    @Override
    public Page<ProductDTO> searchByTitle(String keyword, Pageable pageable){
        return productRepository.findByTitleContaining(keyword, pageable)
                .map(this::toDTO);
    }

}





