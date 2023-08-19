package com.kmt.service;

import com.kmt.domain.Restaurant;
import com.kmt.domain.Review;
import com.kmt.domain.User;
import com.kmt.dto.RestaurantRegisterReqDto;
import com.kmt.dto.RestaurantResDto;
import com.kmt.dto.ReviewReqDto;
import com.kmt.repository.RestaurantRepository;
import com.kmt.repository.ReviewRepository;
import com.kmt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class Service {

    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;

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
    public Float getRate(Restaurant restaurant) {
        float rate, rateSum = 0;

        //restaurantId를 통해 모든 rate 가져와서 더함
        List<Review> reviews = reviewRepository.findByRestaurantId(restaurant.getId());

        for (Review review : reviews) {
            rateSum += review.getRate();
        }

        if (reviews.size() == 0) {
            return null;
        }

        rate = rateSum / reviews.size();

        return rate;
    }

    //평균 배달 시간
    public Integer getDeliveryTimeAverage(Restaurant restaurant) {

        int deliveryAverage;
        float deliverySum = 0;

        //restaurantId를` 통해 모든 rate 가져와서 더함
        List<Review> reviews = reviewRepository.findByRestaurantId(restaurant.getId());

        for (Review review : reviews) {
            deliverySum += review.getDeliveryTime();
        }

        if (reviews.size() == 0) {
            return null;
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

    public void postReview(final ReviewReqDto reviewReqDto) {
        float rate = reviewReqDto.getRate();
        String comment = reviewReqDto.getComment();
        Boolean isDelivery = reviewReqDto.getIsDelivery();
        Integer deliveryTime = reviewReqDto.getDeliveryTime();

        Restaurant restaurant = restaurantRepository.findById(reviewReqDto.getRestaurantId()).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 식당 id 입니다."));
        User user = userRepository.findById(reviewReqDto.getUserId()).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 user id 입니다."));
        Review review = Review.newInstance(rate, comment, isDelivery, deliveryTime, restaurant, user);
        reviewRepository.save(review);
    }
}

