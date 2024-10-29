package com.userservice.userservice.controller;

import com.userservice.userservice.entity.User;
import com.userservice.userservice.repository.UserRepository;
import com.userservice.userservice.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //create
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User user1 = userService.saveUser(user);
        return new ResponseEntity<User>(user1, HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable String userId) {
        User user = userService.deleteUserById(userId);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    //getById
    int retryCount = 1;
    @GetMapping("/{userId}")
    @RateLimiter(name = "RATE_LIMITER", fallbackMethod = "ratingHotelFallBack")
    @CircuitBreaker(name = "RATING_HOTEL_BREAKER" , fallbackMethod = "ratingHotelFallBack")
    @Retry(name = "RATING_HOTEL_BREAKER", fallbackMethod = "ratingHotelFallBack")
    public ResponseEntity<User> getUserById(@PathVariable String userId) {
        logger.info("Retry count {}", retryCount);
        retryCount++;
        User userById = userService.getUserById(userId);
        return new ResponseEntity<User>(userById, HttpStatus.OK);
    }


    public ResponseEntity<User> ratingHotelFallBack(String userId, Exception ex) {
        logger.info("FallBack is executed because service is down : ", ex.getMessage());
        User dummy = User.builder()
                .email("dummy@gmail.com")
                .name("Dummy")
                .about("This is about failed response that took place")
                .build();
        return new ResponseEntity<User>(dummy, HttpStatus.OK);
    }
    //getByAll
    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        List<User> allByUser = userService.getAllByUser();
        return new ResponseEntity<List<User>>(allByUser, HttpStatus.OK);
    }


}
