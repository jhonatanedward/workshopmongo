package com.jedward.workshopmongo.resources.exception;

import com.jedward.workshopmongo.services.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException obj, HttpServletRequest request) {

        HttpStatus httpStatus = HttpStatus.NOT_FOUND;

        StandardError err = new StandardError(
                System.currentTimeMillis(),
                httpStatus.value(),
                "User não encontrado",
                obj.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(httpStatus).body(err);
    }
}
