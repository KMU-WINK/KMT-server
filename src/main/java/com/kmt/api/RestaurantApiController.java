package com.kmt.api;


import com.kmt.domain.Restaurant;
import com.kmt.dto.ReRestaurantDTO;
import com.kmt.dto.RestaurantDTO;
import com.kmt.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class RestaurantApiController {

    private final RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<RestaurantDTO>  restaurantList() {

        List<RestaurantDTO> restaurantDTOList = new ArrayList<>();

        List<Restaurant> restaurants = restaurantService.findRestaurants();

        for (Restaurant restaurant : restaurants) {
            float rate = restaurantService.getRate(restaurant);
            int deliveryTime = restaurantService.getDeliveryTimeAverage(restaurant);

            RestaurantDTO restaurantDTO = new RestaurantDTO(
                    restaurant.getId(),
                    restaurant.getName(),
                    rate,
                    deliveryTime,
                    restaurant.getLatitude(),
                    restaurant.getLongtitude()
            );

            restaurantDTOList.add(restaurantDTO);
        }

        return restaurantDTOList;
    }
}
