package com.evaluation.ms.client.msclient.domain.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@ToString
public class ApiException extends RuntimeException{
    private final HttpStatus httpStatus;
    private final String message;
    private final Object[] args;
}
