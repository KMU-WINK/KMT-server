package com.kmt.domain;

import javax.persistence.*;

import com.kmt.dto.RestaurantDTO;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Entity
@Builder
@AllArgsConstructor
@Table(name="restaurant_tb")
@Getter
public class Restaurant {
    public Restaurant() {}

    private Restaurant(final String name, final Double latitude, final Double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Id @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private double latitude;

    @NotNull
    private double longitude;

    @NotNull
    public static Restaurant newInstance(final String name, final Double latitude, final Double longitude) {
        return new Restaurant(name, latitude, longitude);
    }

    public static Restaurant toEntity(RestaurantDTO dto) {
        return Restaurant.builder()
                .id(dto.getId())
                .name(dto.getName())
                .latitude(dto.getLatitude())
                .longitude(dto.getLongtitude())
                .build();
    }
}
