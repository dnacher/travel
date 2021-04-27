package com.travels.travel.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(TravelException.class)
    public ResponseEntity<ApiErrorResponse> handleApiException(TravelException ex){
        ApiErrorResponse response = new ApiErrorResponse(ex.getCode(),
                ex.getMessage());
        return new ResponseEntity<>(response, ex.getStatus());
    }
}
