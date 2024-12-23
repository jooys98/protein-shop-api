package com.example.protainshop.service;


import com.example.protainshop.dto.CartDTO;
import com.example.protainshop.entity.Cart;
import com.example.protainshop.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor

public class CartServiceImpl implements CartService {


    private final CartRepository cartRepository;


    @Transactional(readOnly = true)

    public List<Cart> readCarts(){
        return cartRepository.findAll();
    }

@Override
    public void removeFromCart(Long id){
       cartRepository.deleteById(id);

    }
@Override
public void updateCart(Cart cart){
        Cart updatedCart = cartRepository.findById(cart.getId())
                .orElseThrow(()-> new IllegalArgumentException("장바구니에 존재하지 않는 상품입니다 "));
                updatedCart.setQuantity(cart.getQuantity());
                cartRepository.save(updatedCart);
}
@Override
public Cart getCartById(Long id){
        return cartRepository.findById(id).orElse(null);
}

//@Override
//    public void createCartItem(Cart cart) {
//    Cart cart = Cart.builder()
//            .title(cart.getTitle())
//            .price(cart.getPrice())
//            .imgsrc(cart.getImgsrc())
//            .quantity(cart.getQuantity())
//            .build();
//            cartRepository.save(cart);
//    }

    @Override
    public void createCartItem(CartDTO cartDTO) {
        Cart cart = convertToEntity(cartDTO); // DTO → 엔티티 변환
        cartRepository.save(cart);           // 엔티티 저장
    }

    private Cart convertToEntity(CartDTO cartDTO) {
        return Cart.builder()
                .id(cartDTO.getId())
                .title(cartDTO.getTitle())
                .price(cartDTO.getPrice())
                .imgsrc(cartDTO.getImgsrc())
                .quantity(cartDTO.getQuantity())
                .build();
    }

}
