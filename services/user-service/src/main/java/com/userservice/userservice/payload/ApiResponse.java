package com.userservice.userservice.payload;


import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ApiResponse {

    private String message;
    private Boolean success;
    private HttpStatus status;
}
