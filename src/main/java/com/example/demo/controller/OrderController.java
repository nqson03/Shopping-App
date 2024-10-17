package com.example.demo.controller;

public class OrderController {
    // Đặt hàng
    @PostMapping
    public ResponseEntity<String> placeOrder(@RequestBody OrderDto orderDto) {
        orderService.placeOrder(orderDto);
        return ResponseEntity.ok("Order placed successfully");
    }

    // Xem danh sách đơn hàng - admin
    @GetMapping
    public ResponseEntity<List<Order>> listOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    // Xem chi tiết đơn hàng
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Order order = orderService.getOrderById(id);
        return ResponseEntity.ok(order);
    }
}
