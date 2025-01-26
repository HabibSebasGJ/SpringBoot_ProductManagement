package com.products.Products.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.products.Products.Model.Product;

public interface ProductRepository extends JpaRepository <Product, Long> {
    List<Product>findByPriceLessThan(double price);
    List<Product>findByCategory(String category);
    List<Product>findByNameContaining(String name);
    
    
}
