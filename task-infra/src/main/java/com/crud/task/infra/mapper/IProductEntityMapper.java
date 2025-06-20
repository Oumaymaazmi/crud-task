package com.crud.task.infra.mapper;

import com.crud.task.domain.pojo.Product;
import com.crud.task.infra.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IProductEntityMapper extends IMapper<ProductEntity, Product> {
}
