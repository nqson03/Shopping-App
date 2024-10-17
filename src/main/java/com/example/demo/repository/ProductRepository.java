package com.example.demo.repository;

import com.example.demo.dto.response.ProductResponse;
import com.example.demo.repository.entity.ProductEntity;

import java.util.List;
import java.util.Map;

public interface ProductRepository {
    List<ProductEntity> findAll(Map<String,String> params);
}
