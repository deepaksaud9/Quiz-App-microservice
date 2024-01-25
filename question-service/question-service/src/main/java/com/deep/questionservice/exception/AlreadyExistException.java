package com.deep.questionservice.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AlreadyExistException extends RuntimeException {

    private int statusCode;
    private String message;

    public AlreadyExistException(String message){
        super(message);
    }
}
