package com.clock.clockconverter;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TimeControllerExceptionHandler {
	
	@ExceptionHandler(InvalidTimeException.class)
    public ResponseEntity<String> handleInvalidTimeException(InvalidTimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
