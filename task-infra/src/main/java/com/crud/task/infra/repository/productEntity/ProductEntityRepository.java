package com.crud.task.infra.repository.productEntity;

import com.crud.task.domain.pojo.Product;
import com.crud.task.domain.port.IProductRepository;
import com.crud.task.infra.entity.ProductEntity;
import com.crud.task.infra.mapper.IProductEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@AllArgsConstructor
@Service
public class ProductEntityRepository implements IProductRepository {

    private final IProductEntityRepository productEntityRepository;
    private final IProductEntityMapper productEntityMapper;

    @Override
    public Product findById(Long id) {
        Optional<ProductEntity> productEntity = productEntityRepository.findById(id);
        return productEntityMapper.entityToPojo(productEntity.get());
    }
}
