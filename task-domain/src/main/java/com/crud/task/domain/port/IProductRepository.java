package com.crud.task.domain.port;

import com.crud.task.domain.pojo.Product;

import java.util.Optional;

public interface IProductRepository {

    Optional<Product> findById(Long id);

}
