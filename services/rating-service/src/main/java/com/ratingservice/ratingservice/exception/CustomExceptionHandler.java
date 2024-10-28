package com.ratingservice.ratingservice.exception;

import com.ratingservice.ratingservice.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(NoRatingFoundException.class)
    public ResponseEntity<ApiResponse> handleRatingException(NoRatingFoundException noRatingFoundException) {

        String message = noRatingFoundException.getMessage();
        ApiResponse build = ApiResponse.builder().message(message).success(true).httpStatus(HttpStatus.NOT_FOUND).build();

        return new ResponseEntity<ApiResponse>(build, HttpStatus.OK);
    }
}
