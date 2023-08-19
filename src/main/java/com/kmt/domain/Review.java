package com.kmt.domain;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Review {

    public Review() {}

    private Review(final float rate, final String comment,
                   final Boolean isDelivery, final Integer deliveryTime,
                   final Restaurant restaurant, final User user
                   ) {
        this.rate = rate;
        this.comment = comment;
        this.isDelivery = isDelivery;
        this.deliveryTime = deliveryTime;
        this.restaurant = restaurant;
        this.user = user;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private float rate;

    @Nullable
    private String comment;

    @NotNull
    private boolean isDelivery;

    @Nullable
    private int deliveryTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public static Review newInstance(final float rate, final String comment,
                                     final Boolean isDelivery, final Integer deliveryTime,
                                     final Restaurant restaurant, final User user) {
        return new Review(rate, comment, isDelivery, deliveryTime, restaurant , user);
    }
}
