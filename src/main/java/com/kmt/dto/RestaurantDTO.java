package com.kmt.dto;

import com.kmt.domain.Restaurant;
import lombok.*;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDTO {

    private Long id;
    private String name;
    private Float raitng;
    private Integer deliveryTime;
    private double latitude;
    private double longitude;

}
