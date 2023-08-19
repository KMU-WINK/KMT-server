package com.kmt.dto;

import lombok.Getter;

@Getter
public class RestaurantRegisterReqDto {
    private String name;
    private Double latitude; // 위도
    private Double longitude; // 경도
}
