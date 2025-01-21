package com.products.Products.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.Products.Model.Product;
import com.products.Products.Repository.ProductRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product){
        return productRepository.save(product);
    } 

    @GetMapping("/lessPrice/{price}")
    public List<Product> productLess(@PathVariable double price){
        return productRepository.findByPriceLessThan(price);
    } 
    
    @GetMapping("/search")
    public List<Product> searchProduct(@RequestParam String name){
        return productRepository.findByNameContaining(name);
    }
    
}
