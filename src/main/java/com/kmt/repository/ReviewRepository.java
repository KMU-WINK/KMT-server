package com.kmt.repository;

import com.kmt.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository <Review, Long>{

    List<Review> findByRestaurantId(Long restaurantId);
}
