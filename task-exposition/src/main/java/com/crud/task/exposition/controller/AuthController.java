package com.crud.task.exposition.controller;

import com.crud.task.exposition.in.AppUserIn;
import com.crud.task.exposition.mapper.user.IAuthMapper;
import com.crud.task.exposition.mapper.user.IUserInMapper;
import com.crud.task.service.dto.AuthenticationResult;
import com.crud.task.service.services.user.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@AllArgsConstructor
public class AuthController {

    private final AppUserService userService;
    private final IUserInMapper mapperIn;
    private final IAuthMapper authMapper;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AppUserIn user) {
        userService.saveUser(mapperIn.inOutToDto(user));
        return ResponseEntity.ok("User successfully saved");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AppUserIn user) {
        AuthenticationResult result = userService.login(mapperIn.inOutToDto(user));
        return ResponseEntity.ok(authMapper.dtoToInOut(result));
    }
}
