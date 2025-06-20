package com.crud.task.service.services.product;

import com.crud.task.domain.pojo.Product;
import com.crud.task.domain.port.IProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product findById(Long id) {
        return productRepository.findById(id);
    }
}
