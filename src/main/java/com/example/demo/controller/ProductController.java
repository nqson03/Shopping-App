package com.example.demo.controller;

import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.response.ProductResponse;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products/")
public class ProductController {

    @Autowired
    private ProductService productService;

    //lấy tất cả sp hoặc lấy 1 sản phẩm cụ thể: id
    // hoặc lọc theo nhiều điều kiện:, name, brand_id, category_id, min_price,max price, sort
    @GetMapping
    public List<ProductResponse> findAll(@RequestParam Map<String,String> params){
        System.out.println(params);
        return productService.findAll(params);
    }

//    NÊN BỎ KHÔNG
//    // Lấy danh sách sản phẩm
//    @GetMapping
//    public List<ProductResponse> listAllProducts() {
//
//    }
//
//    // Lọc theo brand
//    @GetMapping("/brand/{brand_id}")
//    public List<ProductResponse> getProductsByBrand(@PathVariable int brand_id) {
//
//    }
//
//    // Lọc theo category
//    @GetMapping("/category/{category_id}")
//    public List<ProductResponse> getProductsByCategory(@PathVariable int category_id) {
//        return productService.getProductsByCategory(category_id);
//    }
//
//    // Lọc theo giá
//    @GetMapping("/price")
//    public ResponseEntity<List<Product>> getProductsByPriceRange(@RequestParam double minPrice, @RequestParam double maxPrice) {
//        List<Product> products = productService.getProductsByPriceRange(minPrice, maxPrice);
//        return ResponseEntity.ok(products);
//    }
//
//    // Tìm kiếm theo tên sản phẩm
//    @GetMapping("/search")
//    public ResponseEntity<List<Product>> searchProductsByName(@RequestParam String name) {
//        List<Product> products = productService.searchProductsByName(name);
//        return ResponseEntity.ok(products);
//    }
//
//    // Lấy chi tiết sản phẩm
//    @GetMapping("/{id}")
//    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
//        Product product = productService.getProductById(id);
//        return ResponseEntity.ok(product);
//    }
//
//    // Sắp xếp theo giá
//    @GetMapping("/sort")
//    public ResponseEntity<List<Product>> sortProductsByPrice(@RequestParam String order) {
//        List<Product> products = productService.sortProductsByPrice(order);
//        return ResponseEntity.ok(products);
//    }

    //thêm, xóa, sửa product - admin
}
