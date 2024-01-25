package com.deep.quizservice.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class NotFoundException extends RuntimeException{
    private int statusCode;
    private String message;

    public NotFoundException(String message){
        this.message=message;
        this.statusCode = HttpStatus.BAD_REQUEST.value();

    }
}
