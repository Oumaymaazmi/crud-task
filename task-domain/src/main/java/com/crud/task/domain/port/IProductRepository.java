package com.crud.task.domain.port;

import com.crud.task.domain.pojo.Product;

public interface IProductRepository {

    Product findById(Long id);
}
