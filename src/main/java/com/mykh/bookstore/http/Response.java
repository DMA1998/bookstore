package com.mykh.bookstore.http;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Builder
@Getter
@JsonInclude(NON_NULL)
public class Response {

    private final LocalDateTime timeStamp;
    private final String message;
    private final String developerMessage;
    private final Map<?,?> dataMap;
    private final HttpStatus status;
    private final int statusCode;
}
