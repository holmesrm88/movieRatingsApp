package com.holmes.movieApplication.service;

import com.holmes.movieApplication.dto.movie.MovieDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface MovieService {
    List<MovieDTO> getAllMovies(int page) throws SQLException, IOException;
    MovieDTO getMovieDetails(String movie);
    List<MovieDTO> getMoviesByYear(String year, int page) throws SQLException, IOException;
    List<MovieDTO> getMoviesByGenre(String genre);

}