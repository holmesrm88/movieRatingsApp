package com.holmes.movieApplication.dto.movie;

import lombok.Data;

import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class MovieDTO {

    private String imdbId;
    private String title;
    private String releaseDate;
    private String budget;
    private String genres;

}
