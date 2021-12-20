package com.example.springboot.demospringbootn11.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductCommentIsEmptyException extends RuntimeException {
    public ProductCommentIsEmptyException(String message) {
        super(message);
    }

}
