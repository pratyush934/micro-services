package com.hotelservice.hotelservice.service;

import com.hotelservice.hotelservice.entity.Hotel;

import java.util.List;

public interface HotelService {

    Hotel saveHotel(Hotel hotel);

    List<Hotel> getAllHotels();

    Hotel getHotelById(String id);

    Hotel deleteHotelById(String id);
}
