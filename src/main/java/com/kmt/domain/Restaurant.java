package com.kmt.domain;

import javax.persistence.*;

import com.sun.istack.NotNull;
import lombok.Getter;

@Entity
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
    private Double latitude;

    @NotNull
    private Double longitude;

    public static Restaurant newInstance(final String name, final Double latitude, final Double longitude) {
        return new Restaurant(name, latitude, longitude);
    }
}
