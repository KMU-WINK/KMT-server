package com.kmt.domain;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name="review_tb")
public class Review {

    @Id @GeneratedValue
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

    //    private Long userId;
}
