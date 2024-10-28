package com.ratingservice.ratingservice.payload;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {

    private String message;
    private Boolean success;
    private HttpStatus httpStatus;
}
