package com.gabrielximenes.userscruds.infra.exceptions;

import com.gabrielximenes.userscruds.domain.exceptions.NotImplementedException;
import com.gabrielximenes.userscruds.domain.exceptions.ObjectDisabledException;
import com.gabrielximenes.userscruds.domain.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e) {
        StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), null, e.getMessage(), Arrays.toString(e.getStackTrace()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(NotImplementedException.class)
    public ResponseEntity<StandardError> notImplementedException(NotImplementedException e) {
        StandardError err = new StandardError(HttpStatus.NOT_IMPLEMENTED.value(), null, e.getMessage(), Arrays.toString(e.getStackTrace()));
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(err);
    }

    @ExceptionHandler(ObjectDisabledException.class)
    public ResponseEntity<StandardError> objectDisabledException(ObjectDisabledException e) {
        StandardError err = new StandardError(HttpStatus.CONFLICT.value(), null, e.getMessage(), Arrays.toString(e.getStackTrace()));
        return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
    }
}
