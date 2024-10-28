package com.userservice.userservice.services;

import com.userservice.userservice.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;



public interface UserService {

    User saveUser(User user);

    User getUserById(String UserId);

    User deleteUserById(String UserId);

    List<User> getAllByUser();

}
