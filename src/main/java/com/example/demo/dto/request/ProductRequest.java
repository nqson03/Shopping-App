package com.example.demo.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    private String name;

    private double price;

    private String img;

    private String desc;

    private int sold;

    private int qty;

    private int brandId;

    private int categoryId;
}
