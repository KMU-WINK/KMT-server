package com.kmt.dto;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDto {

    private int id;
    private float rate;
    private String comment;
    private int deliveryTime;
}
