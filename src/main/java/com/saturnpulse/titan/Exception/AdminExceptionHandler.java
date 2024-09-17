package com.saturnpulse.titan.Exception;


import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class AdminExceptionHandler {


//    @ExceptionHandler(AdminException.class)
//    public ResponseEntity<AdminExceptionCode> noUserFoundException(AdminException e) {
//        AdminExceptionCode adminExceptionCode =
//                AdminExceptionCode.builder()
//                        .errorCode(HttpStatus.NOT_FOUND.value())
//                        .httpStatus(HttpStatus.NOT_FOUND)
//                        .message(Collections.singletonList(e.getMessage()))
//                        .timestamp(new Timestamp(System.currentTimeMillis()))
//                        .build();
//        return new ResponseEntity<AdminExceptionCode>
//                (adminExceptionCode, HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<AdminExceptionCode>
    invalidInput(MethodArgumentNotValidException e) {


        List<String> exceptions =
                e.getBindingResult().getFieldErrors()
                        .stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList();
        AdminExceptionCode adminExceptionCode =
                AdminExceptionCode.builder()
                        .errorCode(HttpStatus.BAD_REQUEST.value())
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .message(exceptions)
                        .timestamp(new Timestamp(System.currentTimeMillis()))
                        .build();
        return new ResponseEntity<AdminExceptionCode>(adminExceptionCode, HttpStatus.BAD_REQUEST);

    }
}
