package com.crud.task.domain.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FunctionalException extends RuntimeException {

    public FunctionalException(String message) {
        super(message);
    }
}
