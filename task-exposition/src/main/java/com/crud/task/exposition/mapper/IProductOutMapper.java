package com.crud.task.exposition.mapper;

import com.crud.task.domain.pojo.Product;
import com.crud.task.exposition.out.ProductOut;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IProductOutMapper extends IMapperInOut<Product, ProductOut> {
}
