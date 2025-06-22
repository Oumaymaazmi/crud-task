package com.crud.task.exposition.out;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class AuthResponse {
    private String token;
    private String email;
}
