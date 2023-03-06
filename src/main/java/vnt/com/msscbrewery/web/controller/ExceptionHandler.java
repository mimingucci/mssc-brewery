package vnt.com.msscbrewery.web.controller;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> validateErrorHandler(ConstraintViolationException e){
       List<String> ex=new ArrayList<>(e.getConstraintViolations().size());
       e.getConstraintViolations().forEach(exc->ex.add(exc.getPropertyPath()+" : "+exc.getMessage()));
       return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(BindException.class)
    public ResponseEntity<List> handleBindException(BindException ex){
        return new ResponseEntity(ex.getAllErrors(), HttpStatus.BAD_REQUEST);
    }
}
