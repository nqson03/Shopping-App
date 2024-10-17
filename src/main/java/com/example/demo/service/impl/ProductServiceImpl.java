package com.example.demo.service.impl;

import com.example.demo.dto.response.ProductResponse;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.entity.ProductEntity;
import com.example.demo.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductResponse> findAll(Map<String,String> params){
        List<ProductEntity> productEntities = productRepository.findAll(params);

        List<ProductResponse> productResponses = new ArrayList<>();
        for(ProductEntity item : productEntities){
            ProductResponse productResponse = modelMapper.map(productEntities,ProductResponse.class);
            productResponses.add(productResponse);
        }
        return productResponses;
    }


}
