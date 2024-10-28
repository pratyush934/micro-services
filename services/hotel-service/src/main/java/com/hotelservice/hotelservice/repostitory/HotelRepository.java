package com.hotelservice.hotelservice.repostitory;

import com.hotelservice.hotelservice.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, String> {
}
