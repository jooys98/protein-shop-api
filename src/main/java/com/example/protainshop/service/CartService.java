package com.example.protainshop.service;

import com.example.protainshop.dto.CartDTO;
import com.example.protainshop.entity.Cart;

import java.util.List;

public interface CartService {
    List<Cart> readCarts();

    void removeFromCart(Long id);

    void updateCart(Cart cart);

    Cart getCartById(Long id);

    void createCartItem(CartDTO cartDTO);


}

//장바구니 전체보기
//장바구니에서 삭제하기
//장바구니 상품 수량 수정하기
//장바구니 상품 상세조회