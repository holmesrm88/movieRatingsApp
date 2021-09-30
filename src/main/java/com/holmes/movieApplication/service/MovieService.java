package com.holmes.movieApplication.service;

import com.holmes.movieApplication.dto.MovieDTO;

import java.sql.SQLException;
import java.util.List;

public interface MovieService {
    List<MovieDTO> getAllMovies() throws SQLException;
    MovieDTO getMovieDetails(String movie) throws SQLException;
    List<MovieDTO> getMoviesByYear(String year);
    List<MovieDTO> getMoviesByGenre(String genre);

}
