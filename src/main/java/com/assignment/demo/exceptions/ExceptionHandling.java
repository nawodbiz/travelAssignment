//package com.assignmentDemo.demo2.exceptions;
//
//import com.assignmentDemo.demo2.pojo.SearchResponse;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
//
//@ControllerAdvice
//public class ExceptionHandling {
//
//    private static final String FAILED_STATUS = "failed";
//
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
//    public ResponseEntity<SearchResponse> MethodArgumentTypeMismatchException (MethodArgumentTypeMismatchException e){
//        return new ResponseEntity<>(SearchResponse.create().)
//
//    }
//}
