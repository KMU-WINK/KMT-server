package com.kmt.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class RestaurantApiController {

//    private final RestaurantService restaurantService;
//
//    @GetMapping("/restaurants")
//    public List<Restaurant>() {
//        return restaurantService.findRestaurants();
//    }
}
