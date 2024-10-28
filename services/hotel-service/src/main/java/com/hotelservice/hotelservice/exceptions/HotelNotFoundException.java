package com.hotelservice.hotelservice.exceptions;

public class HotelNotFoundException extends RuntimeException {

    public HotelNotFoundException() {
        super("Hotel was not found there");
    }

    public HotelNotFoundException(String s) {
        super(s);
    }
}
