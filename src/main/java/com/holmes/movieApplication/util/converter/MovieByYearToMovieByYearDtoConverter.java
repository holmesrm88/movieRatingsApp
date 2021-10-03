package com.holmes.movieApplication.util.converter;

import com.holmes.movieApplication.dto.MovieByYear.MovieByYearDTO;
import com.holmes.movieApplication.model.movie.MovieByYear;
import com.holmes.movieApplication.util.MovieApplicationUtil;
import lombok.extern.java.Log;

import java.io.IOException;
import java.sql.SQLException;

@Log
public class MovieByYearToMovieByYearDtoConverter {

    public MovieByYearDTO converter(MovieByYear movie) {
        MovieByYearDTO dto = new MovieByYearDTO();

        try {
            dto.setBudget(movie.getBudget() == null ? null : "$" + movie.getBudget());
            dto.setGenres(movie.getGenres() == null ? null : MovieApplicationUtil.clobToString(movie.getGenres()));
            dto.setImdbId(movie.getImdbId() == null ? null : movie.getImdbId());
            dto.setTitle(movie.getTitle() == null ? null : movie.getTitle());
            dto.setReleaseDate(movie.getReleaseDate() == null ? null : movie.getReleaseDate());
        } catch (SQLException throwables) {
            log.info("SQL Exception occurred: " + throwables.getMessage());
            throwables.printStackTrace();
        } catch (IOException e) {
            log.info("IOException occurred: " + e.getMessage());
            e.printStackTrace();
        }
        return dto;
    }

}
