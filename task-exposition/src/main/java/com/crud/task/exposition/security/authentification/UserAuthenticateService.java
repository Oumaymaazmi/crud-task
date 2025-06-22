package com.crud.task.exposition.security.authentification;

import com.crud.task.domain.exception.FunctionalException;
import com.crud.task.domain.pojo.AppUser;
import com.crud.task.service.services.user.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserAuthenticateService implements UserDetailsService {

    private final AppUserService userService;

    private final IUserDetailsMapper userDetailMapper;

    @Override
    public AppUserDetails loadUserByUsername(String username) {
        if (username == null || username.isEmpty()) {
            throw new FunctionalException("Empty user");
        }
        AppUser user = userService.findByUserName(username);
        return userDetailMapper.entityToPojo(user);
    }
}
