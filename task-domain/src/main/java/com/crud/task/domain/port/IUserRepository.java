package com.crud.task.domain.port;

import com.crud.task.domain.pojo.AppUser;

public interface IUserRepository {

    AppUser findByUserName(String username);

    void save(AppUser user);
}
