package com.crud.task.infra.repository.productEntity;

import com.crud.task.infra.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductEntityRepository extends JpaRepository<ProductEntity, Long> {
}
