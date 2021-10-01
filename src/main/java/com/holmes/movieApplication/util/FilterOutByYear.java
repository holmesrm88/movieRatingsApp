package com.holmes.movieApplication.util;

import com.holmes.movieApplication.dto.movie.MovieDTO;

import java.util.ArrayList;
import java.util.List;

public class FilterOutByYear {
    public List<MovieDTO> filterMoviesByYear(List<MovieDTO> movieDTOS, String year){
        List<MovieDTO> movies = new ArrayList<>();

        for(MovieDTO m : movieDTOS){
            if(m.getReleaseDate().substring(0, 4).equals(year)){
                movies.add(m);
            }
        }

        return movies;
    }
}
