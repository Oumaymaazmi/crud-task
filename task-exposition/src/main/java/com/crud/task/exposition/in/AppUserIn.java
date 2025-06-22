package com.crud.task.exposition.in;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@AllArgsConstructor
public class AppUserIn {

    @NotNull(message = "Username is required")
    private String username;

    @NotNull(message = "Password is required")
    private String password;

}
