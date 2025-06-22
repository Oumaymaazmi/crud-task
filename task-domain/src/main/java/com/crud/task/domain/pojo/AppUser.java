package com.crud.task.domain.pojo;

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
public class AppUser {

    protected Long id;

    private String username;

    private String password;

}
