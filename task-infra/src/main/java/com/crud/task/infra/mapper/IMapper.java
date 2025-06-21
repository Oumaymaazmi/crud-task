package com.crud.task.infra.mapper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

public interface IMapper<E, P> {

    P entityToPojo(E entity);

    E pojoToEntity(P dto);

    List<P> listEntitiesToPojos(List<E> entities);

    List<E> listPojosToEntities(List<P> entities);


    default Page<P> mapPage(Page<E> source) {
        List<P> outList = listEntitiesToPojos(source.getContent());
        return new PageImpl<>(outList, source.getPageable(), source.getTotalElements());
    }
}
