package com.holmes.movieApplication.util.converter;

import com.holmes.movieApplication.dto.movieDetail.MovieDetailsDTO;
import com.holmes.movieApplication.model.rating.MovieDetails;
import com.holmes.movieApplication.util.MovieApplicationUtil;

import java.io.IOException;
import java.sql.SQLException;

public class MovieDetailsToMovieDetailDtoConverter {

    public MovieDetailsDTO converter(MovieDetails details) {
        MovieDetailsDTO dto = new MovieDetailsDTO();

        try {
            dto.setImdbId(details.getImdbId() == null ? null : details.getImdbId());
            dto.setTitle(details.getTitle() == null ? null : details.getTitle());
            dto.setOverview(details.getOverview() == null ? null : MovieApplicationUtil.clobToString(details.getOverview()));
            dto.setReleaseDate(details.getReleaseDate() == null ? null : details.getReleaseDate());
            dto.setBudget(details.getBudget() == null ? null : "$" + details.getBudget());
            dto.setRuntime(details.getRuntime() == null ? null : details.getRuntime());
            dto.setGenres(details.getGenres() == null ? null : MovieApplicationUtil.clobToString(details.getGenres()));
            dto.setLanguage(details.getLanguage() == null ? null : details.getLanguage());
            dto.setProductionCompanies(details.getProductionCompanies() == null ? null : MovieApplicationUtil.clobToString(details.getProductionCompanies()));
            dto.setRating(details.getRating() < 0 ? null : details.getRating());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dto;
    }

}