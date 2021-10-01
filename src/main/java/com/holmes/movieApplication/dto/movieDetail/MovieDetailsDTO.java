package com.holmes.movieApplication.dto.movieDetail;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieDetailsDTO {

    private double rating;
    private String imdbId;
    private String title;
    private String overview;
    private String releaseDate;
    private String budget;
    private Long runtime;
    private String genres;
    private String language;
    private String productionCompanies;
}
