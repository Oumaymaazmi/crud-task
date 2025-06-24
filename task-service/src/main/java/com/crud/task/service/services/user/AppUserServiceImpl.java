package com.crud.task.service.services.user;

import com.crud.task.domain.exception.FunctionalException;
import com.crud.task.domain.pojo.AppUser;
import com.crud.task.domain.port.IUserRepository;
import com.crud.task.service.config.MessageResolver;
import com.crud.task.service.dto.AuthenticationResult;
import com.crud.task.service.utlils.JwtUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class AppUserServiceImpl implements IAppUserService {

    private static final String ERROR_USER_NOT_FOUND = "error.user.notFound";
    private static final String ERROR_USER_EXIST = "error.user.alreadyExist";
    private static final String ERROR_USER_INVALID = "error.user.invalid";

    @Value("${spring.security.oauth2.resourceserver.jwt.secret}")
    private String secretKey;
    @Value("${spring.security.oauth2.resourceserver.jwt.expiration-time}")
    private long EXPIRATION;

    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final MessageResolver messageResolver;

    public AppUserServiceImpl(IUserRepository userRepository, PasswordEncoder passwordEncoder, MessageResolver messageResolver) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.messageResolver = messageResolver;
    }

    @Override
    public AppUser findByUserName(String username) {
        AppUser user = userRepository.findByUserName(username);
        if (user == null) {
            throw new FunctionalException(messageResolver.get(ERROR_USER_NOT_FOUND));
        }
        return user;
    }

    @Override
    public void saveUser(AppUser user) {
        AppUser userFromDb = userRepository.findByUserName(user.getUsername());
        if (userFromDb != null) {
            throw new FunctionalException(messageResolver.get(ERROR_USER_EXIST));
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public AuthenticationResult login(AppUser user) {
        AppUser userFromDb = findByUserName(user.getUsername());
        if (!passwordEncoder.matches(user.getPassword(), userFromDb.getPassword())) {
            throw new FunctionalException(messageResolver.get(ERROR_USER_INVALID));
        }

        JwtUtil jwtUtil = new JwtUtil(secretKey, EXPIRATION);
        String token = jwtUtil.generateToken(user.getUsername());

        return new AuthenticationResult(userFromDb.getUsername(), token);
    }
}
