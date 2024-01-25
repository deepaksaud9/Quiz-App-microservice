package com.deep.quizservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
