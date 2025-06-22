package com.crud.task.service.services.user;

import com.crud.task.domain.exception.FunctionalException;
import com.crud.task.domain.pojo.AppUser;
import com.crud.task.domain.port.IUserRepository;
import com.crud.task.service.config.MessageResolver;
import com.crud.task.service.dto.AuthenticationResult;
import com.crud.task.service.services.jwt.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserService {

    private static final String ERROR_USER_NOT_FOUND = "error.user.notFound";
    private static final String ERROR_USER_EXIST = "error.user.alreadyExist";
    private static final String ERROR_USER_INVALID = "error.user.invalid";


    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final MessageResolver messageResolver;

    public AppUser findByUserName(String username) {
        AppUser user = userRepository.findByUserName(username);
        if (user == null) {
            throw new FunctionalException(messageResolver.get(ERROR_USER_NOT_FOUND));
        }
        return user;
    }

    public void saveUser(AppUser user) {
        AppUser userFromDb = userRepository.findByUserName(user.getUsername());
        if (userFromDb != null) {
            throw new FunctionalException(messageResolver.get(ERROR_USER_EXIST));
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public AuthenticationResult login(AppUser user) {
        AppUser userFromDb = findByUserName(user.getUsername());
        if (!passwordEncoder.matches(user.getPassword(), userFromDb.getPassword())) {
            throw new FunctionalException(messageResolver.get(ERROR_USER_INVALID));
        }
        String token = jwtService.generateToken(user.getUsername());
        return new AuthenticationResult(userFromDb.getUsername(), token);
    }
}
