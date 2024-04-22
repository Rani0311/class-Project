package com.project.productservice.controllers;

import com.project.productservice.models.Product;
import com.project.productservice.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductControllers {

 ProductService productService;
     public  ProductControllers(ProductService productService)
     {
         this.productService=productService;
     }
    @PostMapping("/products")
    public void createProduct()
    {

    }
    @GetMapping("/products")
    public  void getAllProduct()
    {

    }
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Long id)
    {
        return productService.getSingleProduct(id);

    }
    public  void deleteProduct()
    {

    }

}
