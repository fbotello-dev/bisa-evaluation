package com.evaluation.ms.client.msclient.domain.exception;


import org.springframework.http.HttpStatus;

public class BusinessApiException extends ApiException {

    public BusinessApiException(HttpStatus httpStatus, String message, Object... args) {
        super(httpStatus, message, args);
    }
}
