package com.example.protainshop.controller;

import com.example.protainshop.dto.CartDTO;
import com.example.protainshop.entity.Cart;
import com.example.protainshop.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/protain/cart")
@RequiredArgsConstructor


public class CartController {
    private final CartService cartService;

    @GetMapping
    public List<Cart> getCart() {
        return cartService.readCarts();
    }

    @GetMapping("/{id}")
    public Cart getCartById(@PathVariable Long id) {
        return cartService.getCartById(id);
    }

    @PutMapping
    //400번대 오류 발생
    public void updateCart(@RequestBody Cart cart) {
        cartService.updateCart(cart);
    }


    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable Long id) {
        cartService.removeFromCart(id);
    }

    @PostMapping
    //400번대 오류 발생
    public void addToCart(@RequestBody CartDTO cartDTO) {
        cartService.createCartItem(cartDTO);
    }
}
