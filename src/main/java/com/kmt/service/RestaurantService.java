package com.kmt.service;

import com.kmt.domain.Restaurant;
import com.kmt.domain.Review;
import com.kmt.repository.RestaurantRepository;
import com.kmt.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    private final ReviewRepository reviewRepository;

    @Transactional
    public String add(Restaurant restaurant){
        return restaurant.getName();
    }


    public List<Restaurant> findRestaurants() {
        return restaurantRepository.findAll();
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

        //restaurantId를 통해 모든 rate 가져와서 더함
        List<Review> reviews = reviewRepository.findByRestaurantId(restaurant.getId());

        for (Review review : reviews) {
            deliverySum += review.getDeliveryTime();
        }

        deliveryAverage = (int) deliverySum / reviews.size();

        return deliveryAverage;
    }


}
