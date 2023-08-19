package com.kmt.api;

import com.kmt.domain.Review;
import com.kmt.dto.*;
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

    @ApiOperation("리뷰 등록")
    @PostMapping("/review")
    public void postReview(@RequestBody final ReviewReqDto reviewReqDto) {
        service.postReview(reviewReqDto);
    }
    @GetMapping("/restaurant/{id}/reviews")
    public List<ReviewDto> reviewList(@PathVariable("id") Long id) {

        List<ReviewDto> reviewDtoList = new ArrayList<>();

        List<Review> reviews = service.findReviews(id);

        for (Review review : reviews) {
            ReviewDto reviewDto = new ReviewDto(
                    review.getId(),
                    review.getRate(),
                    review.getComment(),
                    review.getDeliveryTime()
            );

            reviewDtoList.add(reviewDto);
        }

        return reviewDtoList;
    }
}
