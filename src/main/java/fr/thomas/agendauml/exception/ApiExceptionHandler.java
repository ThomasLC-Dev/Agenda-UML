package fr.thomas.agendauml.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = {CustomException.class})
    public ResponseEntity<Object> handleElementNotFoundException(CustomException e){
        ApiExceptionWrapper apiExceptionWrapper = new ApiExceptionWrapper(
                e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, ZonedDateTime.now()
        );
        return new ResponseEntity<>(apiExceptionWrapper, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
