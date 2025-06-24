package com.crud.task.service.services.user;

import com.crud.task.domain.pojo.AppUser;
import com.crud.task.service.dto.AuthenticationResult;

public interface IAppUserService {

    AppUser findByUserName(String username);

    void saveUser(AppUser user);

    AuthenticationResult login(AppUser user);
}
