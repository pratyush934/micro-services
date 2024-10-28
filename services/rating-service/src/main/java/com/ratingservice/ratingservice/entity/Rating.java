package com.ratingservice.ratingservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.websocket.server.ServerEndpoint;
import lombok.*;

@Entity
@Table(name = "rating")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    @Id
    private String ratingId;
    private String userId;
    private String hotelId;
    private String feedBack;
    private Integer rating;

}
