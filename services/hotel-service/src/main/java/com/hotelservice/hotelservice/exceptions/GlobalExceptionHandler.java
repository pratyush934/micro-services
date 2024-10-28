package com.hotelservice.hotelservice.exceptions;

import com.hotelservice.hotelservice.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(HotelNotFoundException.class)
    public ResponseEntity<ApiResponse> hotelNotFound(HotelNotFoundException hotelNotFoundException) {
        String message = hotelNotFoundException.getMessage();
        ApiResponse build = ApiResponse.builder().message(message).success(true).httpStatus(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<ApiResponse>(build, HttpStatus.OK);
    }
}
