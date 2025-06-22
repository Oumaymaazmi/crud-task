package com.crud.task.exposition.mapper.user;

import com.crud.task.domain.pojo.AppUser;
import com.crud.task.exposition.in.AppUserIn;
import com.crud.task.exposition.mapper.IMapperInOut;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IUserInMapper extends IMapperInOut<AppUser, AppUserIn> {
}
