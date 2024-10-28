package com.hotelservice.hotelservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "hotel")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Hotel {

    @Id
    private String hotelId;
    private String name;
    private String location;
    private String description;
    private Integer averagePricing;
}
