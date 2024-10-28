package com.userservice.userservice.controller;

import com.userservice.userservice.entity.User;
import com.userservice.userservice.repository.UserRepository;
import com.userservice.userservice.services.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
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
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId) {
        User userById = userService.getUserById(userId);
        return new ResponseEntity<User>(userById, HttpStatus.OK);
    }
    //getByAll
    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        List<User> allByUser = userService.getAllByUser();
        return new ResponseEntity<List<User>>(allByUser, HttpStatus.OK);
    }


}
