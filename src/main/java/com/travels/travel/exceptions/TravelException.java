package com.travels.travel.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TravelException extends RuntimeException{

    private HttpStatus status = HttpStatus.BAD_REQUEST;
    private String code = status.toString();

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public TravelException(String message) {
        super(message);
    }

    public TravelException(String message, HttpStatus status) {
        super(message);
        this.status = status;
        this.code = status.toString();
    }
}
