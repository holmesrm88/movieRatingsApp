package com.holmes.movieApplication.model.rating;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.holmes.movieApplication.model.movie.Movie;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Entity
@Table(name = "ratings")
public class Rating {

    public Rating(){}

    @Id
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

//    @ManyToOne
//    @JoinColumn(name = "movieId", insertable = false, updatable = false)
//    private Movie movie;
}
