package com.userservice.userservice.entity;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Rating {


    private String ratingId;
    private String userId;
    private String hotelId;
    private String feedBack;
    private Integer rating;
    private Hotel hotel;
}
