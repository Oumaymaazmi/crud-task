package com.crud.task.exposition.mapper;

import java.util.List;

public interface IMapperInOut<D, IO> {

    IO dtoToInOut(D dto);

    D inOutToDto(IO inOut);

    List<IO> listDtosToInOuts(List<D> dtos);

    List<D> listInOutsToDtos(List<IO> inOuts);
}
