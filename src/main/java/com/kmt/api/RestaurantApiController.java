package com.kmt.api;

import com.kmt.dto.RestaurantDTO;
import com.kmt.dto.RestaurantRegisterReqDto;
import com.kmt.dto.RestaurantResDto;
import com.kmt.service.RestaurantService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class RestaurantApiController {

    private final RestaurantService restaurantService;

    @ApiOperation("식당 등록")
    @PostMapping("/restaurants")
    public RestaurantResDto registerRestaurant(@RequestBody final RestaurantRegisterReqDto restaurantRegisterReqDto) {
        return restaurantService.registerRestaurant(restaurantRegisterReqDto);
    }

//    @GetMapping("/restaurants")
//    public List<Restaurant>() {
//        return restaurantService.findRestaurants();
//    }


}
