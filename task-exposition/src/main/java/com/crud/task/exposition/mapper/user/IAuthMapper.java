package com.crud.task.exposition.mapper.user;

import com.crud.task.exposition.mapper.IMapperInOut;
import com.crud.task.exposition.out.AuthResponse;
import com.crud.task.service.dto.AuthenticationResult;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IAuthMapper extends IMapperInOut<AuthenticationResult, AuthResponse> {
}
