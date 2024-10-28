package com.userservice.userservice.services.implementation;

import com.userservice.userservice.entity.Hotel;
import com.userservice.userservice.entity.Rating;
import com.userservice.userservice.entity.User;
import com.userservice.userservice.exception.ResourceNotFoundException;
import com.userservice.userservice.external.HotelService;
import com.userservice.userservice.repository.UserRepository;
import com.userservice.userservice.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public HotelService hotelService;


    @Autowired
    public RestTemplate restTemplate;

    public UserServiceImpl(UserRepository userRepository, RestTemplate restTemplate, HotelService hotelService) {
        this.userRepository = userRepository;
        this.hotelService = hotelService;
        this.restTemplate = restTemplate;
    }

    @Override
    public User saveUser(User user) {
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);
        return userRepository.save(user);
    }

    @Override
    public User getUserById(String UserId) {
        User user = userRepository.findById(UserId).orElseThrow(
                () -> new ResourceNotFoundException("So Sorry but we don't get the user in the db" + UserId)
        );
        Rating[] forObject = restTemplate.getForObject("http://RATING-SERVICE/api/v1/ratings/users/"+user.getUserId(), Rating[].class);
        logger.info("{}",  forObject);
        assert forObject != null;
        List<Rating> list = Arrays.stream(forObject).toList();
        List<Rating> ratingList = list.stream().map(rating -> {
            //call the api of hotel service with the hotelId;
            //http://localhost:8082/api/v1/hotels/75935f5b-e17b-434b-8e34-20274d76101a
            //get the Hotel
//            Hotel hotelsWithId = restTemplate.getForEntity("http://HOTEL-SERVICE/api/v1/hotels/" + rating.getHotelId(), Hotel.class).getBody();
            //set the Hotel to rating
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);
            //return the rating return rating;
            return rating;
        }).collect(Collectors.toList());
        user.setRatings(ratingList);
        return user;
    }

    @Override
    public User deleteUserById(String UserId) {
        User user = getUserById(UserId);
        userRepository.deleteById(UserId);
        return user;
    }

    @Override
    public List<User> getAllByUser() {
        //resttemplate ko implement kare
        return userRepository.findAll();
    }
}
