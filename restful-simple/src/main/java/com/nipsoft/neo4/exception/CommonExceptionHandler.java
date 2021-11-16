package com.nipsoft.neo4.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class CommonExceptionHandler {


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity  exceptionHandler(Exception e){
        e.printStackTrace();

        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
