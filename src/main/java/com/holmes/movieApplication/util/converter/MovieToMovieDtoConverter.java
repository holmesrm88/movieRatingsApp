package com.holmes.movieApplication.util.converter;

import com.holmes.movieApplication.dto.movie.MovieDTO;
import com.holmes.movieApplication.model.movie.Movie;
import com.holmes.movieApplication.util.MovieApplicationUtil;
import lombok.extern.java.Log;

import java.io.IOException;
import java.sql.SQLException;

@Log
public class MovieToMovieDtoConverter {
    public MovieDTO converter(Movie movie) {
        MovieDTO movieDTO = new MovieDTO();

        try {
            movieDTO.setBudget(movie.getBudget() == null ? null : "$" + movie.getBudget());
            movieDTO.setGenres(movie.getGenres() == null ? null : MovieApplicationUtil.clobToString(movie.getGenres()));
            movieDTO.setImdbId(movie.getImdbId() == null ? null : movie.getImdbId());
            movieDTO.setReleaseDate(movie.getReleaseDate() == null ? null : movie.getReleaseDate());
            movieDTO.setTitle(movie.getTitle() == null ? null : movie.getTitle());
        } catch (SQLException throwables) {
            log.info("SQL Exception occurred: " + throwables.getMessage());
            throwables.printStackTrace();
        } catch (IOException e) {
            log.info("IOException occurred: " + e.getMessage());
            e.printStackTrace();
        }
        return movieDTO;
    }

}
