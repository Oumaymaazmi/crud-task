package com.crud.task.exposition.mapper;

import com.crud.task.domain.pojo.Product;
import com.crud.task.exposition.in.ProductIn;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IProductInMapper extends IMapperInOut<Product, ProductIn> {
}
