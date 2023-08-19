package com.kmt.service;

import com.kmt.domain.Restaurant;
import com.kmt.domain.Review;
import com.kmt.dto.RestaurantRegisterReqDto;
import com.kmt.dto.RestaurantResDto;
import com.kmt.repository.RestaurantRepository;
import com.kmt.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class Service {

    private final RestaurantRepository restaurantRepository;

    private final ReviewRepository reviewRepository;

    @Transactional
    public String add(Restaurant restaurant){
        return restaurant.getName();
    }


    public List<Restaurant> findRestaurants() {
        return restaurantRepository.findAll();
    }

    public List<Review> findReviews(Long id) {
        return reviewRepository.findByRestaurantId(id);
    }

    //평점 가져오기
    public float getRate(Restaurant restaurant) {
        float rate, rateSum = 0;

        //restaurantId를 통해 모든 rate 가져와서 더함
        List<Review> reviews = reviewRepository.findByRestaurantId(restaurant.getId());

        for (Review review : reviews) {
            rateSum += review.getRate();
        }

        rate = rateSum / reviews.size();

        return rate;
    }

    //평균 배달 시간
    public int getDeliveryTimeAverage(Restaurant restaurant) {

        int deliveryAverage;
        float deliverySum = 0;

        //restaurantId를` 통해 모든 rate 가져와서 더함
        List<Review> reviews = reviewRepository.findByRestaurantId(restaurant.getId());

        for (Review review : reviews) {
            deliverySum += review.getDeliveryTime();
        }

        deliveryAverage = (int) deliverySum / reviews.size();

        return deliveryAverage;
    }

    public RestaurantResDto registerRestaurant(final RestaurantRegisterReqDto restaurantRegisterReqDto) {
        String name = restaurantRegisterReqDto.getName();
        Double latitude = restaurantRegisterReqDto.getLatitude();
        Double longitude = restaurantRegisterReqDto.getLongitude();

        Restaurant restaurant = Restaurant.newInstance(name, latitude, longitude);
        restaurantRepository.save(restaurant);

        return RestaurantResDto.of(restaurant);
    }
}

