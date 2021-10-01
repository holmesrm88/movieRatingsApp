package com.holmes.movieApplication.model.movie;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.holmes.movieApplication.model.rating.Rating;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Clob;
import java.util.List;

@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @Column(name = "movieId")
    private Integer movieId;

    @Column(name = "imdbId")
    private String imdbId;

    @Column(name = "title")
    private String title;

    @Column(name = "overview")
    private Clob overview;

    @Column(name = "productionCompanies")
    private Clob productionCompanies;

    @Column(name = "releaseDate")
    private String releaseDate;

    @Column(name = "budget")
    private Integer budget;

    @Column(name = "revenue")
    private Integer revenue;

    @Column(name = "runtime")
    private Long runtime;

    @Column(name = "language")
    private String language;

    @Column(name = "genres")
    private Clob genres;

    @Column(name = "status")
    private String status;

//    @OneToMany(mappedBy = "movie")
//    private List<Rating> ratings;
}
