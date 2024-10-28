package com.ratingservice.ratingservice.exception;

public class NoRatingFoundException extends RuntimeException {

    public NoRatingFoundException() {
        super("Sorry we are not there getting any such element");
    }

    public NoRatingFoundException(String s) {
        super(s);
    }
}
