package com.skye8.elroykanye.hyrrebus.exception.advice;

import com.skye8.elroykanye.hyrrebus.exception.EntityException;
import com.skye8.elroykanye.hyrrebus.exception.body.ExceptionBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.security.auth.message.AuthException;
import java.util.List;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {


    // ENTITY EXCEPTION HANDLERS
    @ExceptionHandler(EntityException.EntityNotFoundException.class)
    public ResponseEntity<ExceptionBody> handleEntityNotFoundException(
            EntityException.EntityNotFoundException entityNotFoundException,
            WebRequest webRequest) {
        return getExceptionEntity(entityNotFoundException, webRequest, HttpStatus.NOT_FOUND, List.of("Entity not found"));
    }

    @ExceptionHandler(EntityException.EntityAlreadyExistsException.class)
    public ResponseEntity<ExceptionBody> handleEntityAlreadyExistsException(
            EntityException.EntityAlreadyExistsException entityAlreadyExistsException,
            WebRequest webRequest) {
        return getExceptionEntity(entityAlreadyExistsException, webRequest, HttpStatus.CONFLICT, List.of("Entity already exists"));
    }

    private ResponseEntity<ExceptionBody> getExceptionEntity(
            RuntimeException ex,
            WebRequest webRequest,
            HttpStatus status,
            List<String> messages) {
        ExceptionBody exceptionBody = ExceptionBody.buildExceptionBody(ex, webRequest, status, messages);
        return new ResponseEntity<>(exceptionBody, exceptionBody.getStatus());
    }
}
