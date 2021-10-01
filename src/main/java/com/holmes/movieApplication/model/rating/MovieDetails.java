package com.holmes.movieApplication.model.rating;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Clob;

@Getter
@Setter
@Data
@AllArgsConstructor
public class MovieDetails {

    public MovieDetails(){}

    public MovieDetails(double rating, String imdbId, String title, Clob overview, String releaseDate, Integer budget, Long runtime, Clob genres, String language, Clob productionCompanies) {
        this.rating = rating;
        this.imdbId = imdbId;
        this.title = title;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.budget = budget;
        this.runtime = runtime;
        this.genres = genres;
        this.language = language;
        this.productionCompanies = productionCompanies;
    }

    //@Id
    @Column(name = "ratingId")
    private Integer ratingId;

    @Column(name = "rating")
    private double rating;

    @Column(name = "imdbId")
    private String imdbId;

    @Column(name = "title")
    private String title;

    @Column(name = "overview")
    private Clob overview;

    @Column(name = "releaseDate")
    private String releaseDate;

    @Column(name = "budget")
    private Integer budget;

    @Column(name = "runtime")
    private Long runtime;

    @Column(name = "genres")
    private Clob genres;

    @Column(name = "language")
    private String language;

    @Column(name = "productionCompanies")
    private Clob productionCompanies;
}
