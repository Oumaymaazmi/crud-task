package com.crud.task.infra.mapper;

import java.util.List;

public interface IMapper<E, P> {

    P entityToPojo(E entity);

    E pojoToEntity(P dto);

    List<P> listEntitiesToPojos(List<E> entities);

    List<E> listPojosToEntities(List<P> entities);

}
