package com.crud.task.infra.mapper;

import com.crud.task.domain.pojo.AppUser;
import com.crud.task.infra.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IUserEntityMapper extends IMapper<UserEntity, AppUser> {
}
