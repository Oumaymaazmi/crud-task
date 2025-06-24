package com.crud.task.service.services.product;

import com.crud.task.domain.pojo.Product;
import org.springframework.data.domain.Page;


public interface IProductService {

    Product findById(Long id);

    void create(Product product);

    void update(Long id, Product product);

    void delete(Long id);

    Page<Product> findAllPaginated(int page, int size);
}
