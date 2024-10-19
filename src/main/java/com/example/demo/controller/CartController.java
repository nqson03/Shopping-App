package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class CartController {
    // Thêm sản phẩm vào giỏ hàng
//    @PostMapping
//    public ResponseEntity<String> addToCart(@RequestBody CartItemDto cartItem) {
//        cartService.addProductToCart(cartItem.getProductId(), cartItem.getQuantity());
//        return ResponseEntity.ok("Product added to cart successfully");
//    }
//
//    // Xem giỏ hàng
//    @GetMapping
//    public ResponseEntity<Cart> viewCart() {
//        Cart cart = cartService.getCart();
//        return ResponseEntity.ok(cart);
//    }
//
//
//    @DeleteMapping("/delete")
//    public ResponseEntity<String> removeFromCart(@RequestParam List<Long> productId) {
//        cartService.removeProductFromCart(productId);
//        return ResponseEntity.ok("Product removed from cart");
//    }
}
