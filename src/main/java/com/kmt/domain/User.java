package com.kmt.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Builder
@AllArgsConstructor
@Getter
public class User {

    @Id
    private Long id;

    @NotNull
    private String name;

    public User() {

    }
}
