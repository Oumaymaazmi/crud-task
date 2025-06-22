package com.crud.task.service.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class AuthenticationResult {
    private String token;
    private String email;
}
