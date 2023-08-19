package com.kmt.api;

import com.kmt.dto.RestaurantDTO;
import com.kmt.dto.RestaurantRegisterReqDto;
import com.kmt.dto.RestaurantResDto;
import com.kmt.service.Service;
import io.swagger.annotations.ApiOperation;
import com.kmt.domain.Restaurant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequestMapping
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class ApiController {

    private final Service service;

    @ApiOperation("식당 등록")
    @PostMapping("/restaurants")
    public RestaurantResDto registerRestaurant(@RequestBody final RestaurantRegisterReqDto restaurantRegisterReqDto) {
        return service.registerRestaurant(restaurantRegisterReqDto);
    }

    @GetMapping("/restaurants")
    public List<RestaurantDTO>  restaurantList() {

        List<RestaurantDTO> restaurantDTOList = new ArrayList<>();

        List<Restaurant> restaurants = service.findRestaurants();

        for (Restaurant restaurant : restaurants) {
            float rate = service.getRate(restaurant);
            int deliveryTime = service.getDeliveryTimeAverage(restaurant);

            RestaurantDTO restaurantDTO = new RestaurantDTO(
                    restaurant.getId(),
                    restaurant.getName(),
                    rate,
                    deliveryTime,
                    restaurant.getLatitude(),
                    restaurant.getLongitude()
            );

            restaurantDTOList.add(restaurantDTO);
        }

        return restaurantDTOList;
    }
}
