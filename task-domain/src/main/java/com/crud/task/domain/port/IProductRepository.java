package com.crud.task.domain.port;

import com.crud.task.domain.pojo.Product;

import java.util.List;
import java.util.Optional;

public interface IProductRepository {

    Optional<Product> findById(Long id);

    void save(Product product);

    void deleteById(Long productId);

    List<Product> findAll();
}
