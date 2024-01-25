package com.deep.questionservice.handler;

import com.deep.questionservice.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.rmi.AlreadyBoundException;

@RestControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiResponse> notFoundExceptionHandler(NotFoundException notFoundException){

         ApiResponse apiResponse = new ApiResponse(HttpStatus.BAD_REQUEST.value(), notFoundException.getMessage());
        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AlreadyBoundException.class)
    public ResponseEntity<ApiResponse> notFoundExceptionHandler(AlreadyBoundException alreadyBoundException){

        ApiResponse apiResponse = new ApiResponse(HttpStatus.BAD_REQUEST.value(), alreadyBoundException.getMessage());
        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.BAD_REQUEST);
    }
}
