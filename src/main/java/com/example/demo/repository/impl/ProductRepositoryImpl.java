package com.example.demo.repository.impl;

import com.example.demo.dto.response.ProductResponse;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.entity.BrandEntity;
import com.example.demo.repository.entity.CategoryEntity;
import com.example.demo.repository.entity.ProductEntity;
import com.example.demo.utils.ConnectionJDBCUtil;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    public List<ProductEntity> findAll(Map<String,String> params){
        StringBuilder sql = new StringBuilder(
                "SELECT p.*, b.name AS brand_name, c.name AS category_name " +
                        "FROM products p " +
                        "JOIN brand b ON p.brand_id = b.id " +
                        "JOIN category c ON p.category_id = c.id " +
                        "WHERE 1 = 1"
        );
        if (params.containsKey("id")) {
            sql.append(" AND p.id = " + params.get("id") + " ");
        }
        if (params.containsKey("category_id")) {
            sql.append(" AND p.category_id = " + params.get("category_id") + " ");
        }
        if (params.containsKey("brand_id")) {
            sql.append(" AND p.brand_id = " + params.get("brand_id") + " ");
        }
        if (params.containsKey("min_price")) {
            sql.append(" AND p.price >= " + params.get("min_price") + " ");
        }
        if (params.containsKey("max_price")) {
            sql.append(" AND p.price <= " + params.get("max_price") + " ");
        }
        if (params.containsKey("name")) {
            sql.append(" AND p.name LIKE '%" + params.get("name") + "%' ");
        }
        if (params.containsKey("sortBy")) {
            String sortOrder = "";
            if(params.containsKey("sortOrder")){
                //asc or desc
                sortOrder = params.get("sortOrder");
            }
            sql.append(" ORDER BY " + params.get("sortBy") + " " + sortOrder);
        }

        List<ProductEntity> productEntities = new ArrayList<>();
        try(Connection conn = ConnectionJDBCUtil.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql.toString())){
            while(rs.next()){
                ProductEntity productEntity = new ProductEntity();

                productEntity.setId(rs.getInt("id"));
                productEntity.setName(rs.getString("name"));
                productEntity.setPrice(rs.getDouble("price"));
                productEntity.setImg(rs.getString("img"));
                productEntity.setSold(rs.getInt("sold"));
                productEntity.setQty(rs.getInt("qty"));

                BrandEntity brand = new BrandEntity();
                brand.setId(rs.getInt("brand_id"));
                brand.setName(rs.getString("brand_name"));
                productEntity.setBrand(brand);

                CategoryEntity category = new CategoryEntity();
                category.setId(rs.getInt("category_id"));
                category.setName(rs.getString("category_name"));
                productEntity.setCategory(category);

                productEntities.add(productEntity);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return productEntities;
    }

}
