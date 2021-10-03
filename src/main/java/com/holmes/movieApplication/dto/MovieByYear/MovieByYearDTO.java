package com.holmes.movieApplication.dto.MovieByYear;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class MovieByYearDTO {

    private String imdbId;
    private String title;
    private String releaseDate;
    private String budget;
    private String genres;
}
