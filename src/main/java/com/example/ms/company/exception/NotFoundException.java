package com.example.ms.company.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {
    String code;
    public NotFoundException(String code, String message) {
        super(message);
        this.code = code;
    }
}
