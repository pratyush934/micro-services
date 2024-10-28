package com.hotelservice.hotelservice.service.implmentation;

import com.hotelservice.hotelservice.entity.Hotel;
import com.hotelservice.hotelservice.exceptions.HotelNotFoundException;
import com.hotelservice.hotelservice.repostitory.HotelRepository;
import com.hotelservice.hotelservice.service.HotelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    private HotelRepository hotelRepository;

    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public Hotel saveHotel(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setHotelId(hotelId);
        return hotelRepository.save(hotel);

    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelById(String id) {
        return hotelRepository.findById(id).orElseThrow(() -> new HotelNotFoundException("Sorry, but we are not getting any hotel with the id" + id));
    }

    @Override
    public Hotel deleteHotelById(String id) {
        Hotel hotelById = getHotelById(id);
        hotelRepository.deleteById(id);
        return hotelById;
    }
}
