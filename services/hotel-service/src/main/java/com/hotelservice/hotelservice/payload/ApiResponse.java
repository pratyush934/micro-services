package com.hotelservice.hotelservice.payload;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {

    private String message;
    private Boolean success;
    private HttpStatus httpStatus;
}
