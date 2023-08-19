package com.kmt.domain;

import javax.persistence.*;

import com.kmt.dto.RestaurantDTO;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@Table(name="restaurant_tb")
@Getter
public class Restaurant {

    @Id @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private double latitude;

    @NotNull
    private double longtitude;


    public Restaurant() {
    }

    public static Restaurant toEntity(RestaurantDTO dto) {
        return Restaurant.builder()
                .id(dto.getId())
                .name(dto.getName())
                .latitude(dto.getLatitude())
                .longtitude(dto.getLongtitude())
                .build();
    }
}
