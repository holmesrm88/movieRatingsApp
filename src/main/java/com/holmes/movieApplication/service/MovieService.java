package com.holmes.movieApplication.service;

import com.holmes.movieApplication.dto.MovieByYear.MovieByYearDTO;
import com.holmes.movieApplication.dto.movie.MovieDTO;

import java.util.List;

public interface MovieService {
    List<MovieDTO> getAllMovies(int page);
    List<MovieByYearDTO> getMoviesByYear(String year, int page);
    List<MovieDTO> getMoviesByGenre(String genre);

}