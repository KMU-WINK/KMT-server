package com.kmt.dto;

import lombok.Getter;

@Getter
public class ReviewReqDto {
    private Long restaurantId;
    private String comment;
    private float rate;
    private Boolean isDelivery;
    private Integer deliveryTime;
    private Long userId;
}
