package com.example.subscriber_bc.advicehandler;

import com.example.subscriber_bc.exception.SubscriberException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalAdviceHandler {

    @ExceptionHandler(SubscriberException.class)
    public ResponseEntity<Map<String, Object>> handleSubsciberException(SubscriberException exception) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("message", exception.getMessage());
        response.put("errors", exception.getSubscriberApiErrors());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
