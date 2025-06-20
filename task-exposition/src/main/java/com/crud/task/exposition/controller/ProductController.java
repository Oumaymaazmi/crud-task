package com.crud.task.exposition.controller;

import com.crud.task.domain.pojo.Product;
import com.crud.task.service.services.product.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("{id}")
    public Product getById(@PathVariable Long id) {
        return productService.findById(id);
    }
}
