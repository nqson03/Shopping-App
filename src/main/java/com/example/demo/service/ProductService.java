package com.example.demo.service;

import com.example.demo.dto.response.ProductResponse;

import java.util.List;
import java.util.Map;

public interface ProductService {
    public List<ProductResponse> findAll(Map<String,String> params);

}
