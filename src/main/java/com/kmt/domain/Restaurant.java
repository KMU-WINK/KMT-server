package com.kmt.domain;

import javax.persistence.*;

import com.sun.istack.NotNull;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="restaurant_tb")
@Getter
public class Restaurant {

    @Id @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private float rating;

    @NotNull
    private String location;

    @OneToMany(mappedBy = "restaurant")
    private List<Review> reviews = new ArrayList<>();
}
