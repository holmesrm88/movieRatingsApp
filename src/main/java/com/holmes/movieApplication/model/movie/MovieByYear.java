package com.holmes.movieApplication.model.movie;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.sql.Clob;

@Data
@Getter
@Setter
public class MovieByYear {

    public MovieByYear(String imdbId, String title, String releaseDate, Integer budget, Clob genres) {
        this.imdbId = imdbId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.budget = budget;
        this.genres = genres;
    }

    @Column(name = "movieId")
    private Integer movieId;

    @Column(name = "imdbId")
    private String imdbId;

    @Column(name = "title")
    private String title;

    @Column(name = "releaseDate")
    private String releaseDate;

    @Column(name = "budget")
    private Integer budget;

    @Column(name = "genres")
    private Clob genres;

}
