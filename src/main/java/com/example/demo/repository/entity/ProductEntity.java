package com.example.demo.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProductEntity {

    private int id;

    private String name;

    private double price;

    private String img;

    private String desc;

    private int sold;

    private int qty;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private BrandEntity brand;

    private CategoryEntity category;

    // Getters and Setters
}
