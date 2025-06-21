package com.crud.task.domain.port;

import com.crud.task.domain.pojo.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProductRepository {

    Optional<Product> findById(Long id);

    void save(Product product);

    void deleteById(Long productId);

    Page<Product> findAll(Pageable pageable);
}
