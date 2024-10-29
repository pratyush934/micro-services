package com.apigateway.apigatewayserivce.controllers;

import com.apigateway.apigatewayserivce.payloads.AuthResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    Logger logger = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient client,
            @AuthenticationPrincipal OidcUser user,
            Model model
    ) {

        logger.info("User email id : {}", user.getEmail());
        //creating auth object
        AuthResponse authResponse = new AuthResponse();


        //setting email
        authResponse.setUserId(user.getEmail());

        //setting token to auth response
        authResponse.setAccessToken(client.getAccessToken().getTokenValue());

        authResponse.setRefreshToken(client.getRefreshToken().getTokenValue());

        authResponse.setExpireAt(client.getAccessToken().getExpiresAt().getEpochSecond());

        List<String> authorities = user.getAuthorities().stream().map(grantedAuthority -> {
            return grantedAuthority.getAuthority();
        }).toList();

        authResponse.setAuthorities(authorities);


        return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.OK);


    }
}
