package com.hotelservice.hotelservice.controllers;

import com.hotelservice.hotelservice.entity.Hotel;
import com.hotelservice.hotelservice.service.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hotels")
public class HotelController {


    private HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> allHotels = hotelService.getAllHotels();
        return  new ResponseEntity<List<Hotel>>(allHotels, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel) {
        Hotel hotel1 = hotelService.saveHotel(hotel);
        return new ResponseEntity<Hotel>(hotel1, HttpStatus.OK);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getById(@PathVariable String hotelId) {
        Hotel hotelById = hotelService.getHotelById(hotelId);
        return new ResponseEntity<Hotel>(hotelById, HttpStatus.OK);
    }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity<Hotel> deleteById(@PathVariable String hotelId) {
        Hotel hotel = hotelService.deleteHotelById(hotelId);
        return new ResponseEntity<Hotel>(hotel, HttpStatus.OK);
    }
}
