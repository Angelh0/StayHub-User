package com.angelh0.stayhub_user.exception;

import com.angelh0.stayhub_user.exception.error.ExistEmail;
import com.angelh0.stayhub_user.exception.error.ExistUser;
import com.angelh0.stayhub_user.exception.error.InvalidValues;
import com.angelh0.stayhub_user.exception.error.NotFoundException;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidValues.class)
    public ResponseEntity<ErrorResponse> invalidValues(InvalidValues e) {
        ErrorResponse errorResponse = new ErrorResponse("INVALID_VALUES",
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> notFoundException(NotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse("NOT_FOUND_EXCEPTION",
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExistEmail.class)
    public ResponseEntity<ErrorResponse> existEmail(ExistEmail e) {
        ErrorResponse errorResponse = new ErrorResponse("EXIST_EMAIL",
                e.getMessage(),
                HttpStatus.CONFLICT,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ExistUser.class)
    public ResponseEntity<ErrorResponse> existEmail(ExistUser e) {
        ErrorResponse errorResponse = new ErrorResponse("EXIST_USER",
                e.getMessage(),
                HttpStatus.CONFLICT,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }
}
