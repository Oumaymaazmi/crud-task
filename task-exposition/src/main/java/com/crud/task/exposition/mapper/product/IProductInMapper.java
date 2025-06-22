package com.crud.task.exposition.mapper.product;

import com.crud.task.domain.pojo.Product;
import com.crud.task.exposition.in.ProductIn;
import com.crud.task.exposition.mapper.IMapperInOut;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IProductInMapper extends IMapperInOut<Product, ProductIn> {
}
