package com.holmes.movieApplication.dto;

import com.holmes.movieApplication.model.Genre;
import com.holmes.movieApplication.model.ProductionCompany;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class MovieDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movieId")
    private Integer movieId;

    @Column(name = "imbdId")
    private Integer imdbId;

    @Column(name = "title")
    private String title;

    @Column(name = "overview")
    private String overview;

//    @Column(name = "productionCompanies")
//    @ElementCollection(targetClass = List.class)
//    private List<ProductionCompany> productionCompanies;

    @Column(name = "releaseDate")
    private String releaseDate;

    @Column(name = "budget")
    private double budget;

    @Column(name = "revenue")
    private double revenue;

    @Column(name = "runTime")
    private long runTime;

    @Column(name = "language")
    private String language;

//    @Column(name = "genres")
//    private List<Genre> genres;

    @Column(name = "status")
    private String status;

}
