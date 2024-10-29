package com.apigateway.apigatewayserivce.payloads;

import lombok.*;

import java.util.Collection;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AuthResponse {

    private String userId;
    private String accessToken;
    private String refreshToken;
    private long expireAt;

    private Collection<String> authorities;
}
