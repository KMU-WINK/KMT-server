package com.kmt.dto;

import com.kmt.domain.Restaurant;
import lombok.Getter;

@Getter
public class RestaurantResDto {
    private Long id;
    private String name;
    private Double latitude; // 위도
    private Double longitude; // 경도

    public static RestaurantResDto of(final Restaurant restaurant) {
        return new RestaurantResDto(restaurant);
    }

    private RestaurantResDto(final Restaurant restaurant) {
        this.id = restaurant.getId();
        this.name = restaurant.getName();
        this.latitude = restaurant.getLatitude();
        this.longitude = restaurant.getLongitude();
    }
}
