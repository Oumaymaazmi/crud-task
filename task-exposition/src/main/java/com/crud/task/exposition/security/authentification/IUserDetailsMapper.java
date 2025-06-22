package com.crud.task.exposition.security.authentification;

import com.crud.task.domain.pojo.AppUser;
import com.crud.task.infra.mapper.IMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IUserDetailsMapper extends IMapper<AppUser, AppUserDetails> {
}
