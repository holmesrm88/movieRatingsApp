package com.holmes.movieApplication.dto.rating;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
public class RatingDTO {

    private Integer userId;
    private Integer ratingId;
    private Integer movieId;
    private double rating;
    private Integer timestamp;
    private String imdbId;
    private String title;
    private String overview;
    private String releaseDate;
    private Integer budget;
    private Long runtime;
    private String genres;
    private String language;
    private String productionCompanies;
}
