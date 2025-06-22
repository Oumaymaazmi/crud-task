package com.crud.task.service.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class AuthenticationResult {
    private String token;
    private String email;

    public AuthenticationResult(String email, String token) {
        this.email = email;
        this.token = token;
    }
}
