package com.holmes.movieApplication.model.rating;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "ratings")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ratingId")
    private Integer ratingId;

    @Column(name = "userId")
    private Integer userId;

    @Column(name = "movieId")
    private Integer movieId;

    @Column(name = "rating")
    private double rating;

    @Column(name = "timestamp")
    private Integer timestamp;
}
