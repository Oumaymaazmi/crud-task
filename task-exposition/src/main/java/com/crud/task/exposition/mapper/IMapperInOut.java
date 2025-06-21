package com.crud.task.exposition.mapper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

public interface IMapperInOut<D, IO> {

    IO dtoToInOut(D dto);

    D inOutToDto(IO inOut);

    List<IO> listDtosToInOuts(List<D> dtos);

    List<D> listInOutsToDtos(List<IO> inOuts);

    default Page<IO> mapPage(Page<D> source) {
        List<IO> outList = listDtosToInOuts(source.getContent());
        return new PageImpl<>(outList, source.getPageable(), source.getTotalElements());
    }
}
