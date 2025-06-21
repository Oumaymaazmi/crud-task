package com.crud.task.infra.repository.productEntity;

import com.crud.task.domain.pojo.Product;
import com.crud.task.domain.port.IProductRepository;
import com.crud.task.infra.entity.ProductEntity;
import com.crud.task.infra.mapper.IProductEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductEntityRepository implements IProductRepository {

    private final IProductEntityRepository productEntityRepository;
    private final IProductEntityMapper mapper;

    @Override
    public Optional<Product> findById(Long id) {
        return productEntityRepository.findById(id)
                .map(mapper::entityToPojo);
    }

    @Override
    public void save(Product product) {
        ProductEntity productEntity = mapper.pojoToEntity(product);
        productEntityRepository.save(productEntity);
    }

    @Override
    public void deleteById(Long productId) {
        productEntityRepository.deleteById(productId);
    }

    @Override
    public List<Product> findAll() {
        List<ProductEntity> entities = productEntityRepository.findAll();
        return mapper.listEntitiesToPojos(entities);
    }
}
