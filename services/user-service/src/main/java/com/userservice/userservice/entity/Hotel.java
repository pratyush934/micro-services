package com.userservice.userservice.entity;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Hotel {
    private String hotelId;
    private String ratingId;
    private String userId;
    private String description;
    private String location;
    private String name;

}
