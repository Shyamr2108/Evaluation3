package com.masai.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;

public class Exception {

    @ExceptionHandler(InvalidException.class)
    public ResponseEntity<Error> myHandler(InvalidException ex, WebRequest request){
        Error error =new Error();
        error.setLoacaldatetime(LocalDateTime.now());
        error.setMessage(ex.getMessage());
        error.setDetails(request.getDescription(false));

        return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<?> noHandler(NoHandlerFoundException ex, WebRequest req){
        Error error=new Error();
        error.setMessage(ex.getMessage());
        error.setLoacaldatetime(LocalDateTime.now());
        error.setDetails(req.getDescription(false));
        return new ResponseEntity<Error>(error,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> validException(MethodArgumentNotValidException ex){
        Error error=new Error();
        error.setMessage("Validation Error");
        error.setLoacaldatetime(LocalDateTime.now());
        error.setDetails(ex.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<Error>(error,HttpStatus.BAD_REQUEST);
    }
}
