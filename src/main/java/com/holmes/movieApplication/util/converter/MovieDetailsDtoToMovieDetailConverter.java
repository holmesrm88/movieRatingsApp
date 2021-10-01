package com.holmes.movieApplication.util.converter;

import com.holmes.movieApplication.dto.movie.MovieDTO;
import com.holmes.movieApplication.dto.movieDetail.MovieDetailsDTO;
import com.holmes.movieApplication.model.movie.Movie;
import com.holmes.movieApplication.model.rating.MovieDetails;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.sql.Clob;
import java.sql.SQLException;

public class MovieDetailsDtoToMovieDetailConverter {

    public MovieDetailsDTO coverter(MovieDetails details) throws SQLException, IOException {
        MovieDetailsDTO dto = new MovieDetailsDTO();

        dto.setImdbId(details.getImdbId() == null ? null : details.getImdbId());
        dto.setTitle(details.getTitle() == null ? null : details.getTitle());
        dto.setOverview(details.getOverview() == null ? null : clobToString(details.getOverview()));
        dto.setReleaseDate(details.getReleaseDate() == null ? null : details.getReleaseDate());
        dto.setBudget(details.getBudget() == null ? null : "$" + details.getBudget());
        dto.setRuntime(details.getRuntime() == null ? null : details.getRuntime());
        dto.setGenres(details.getGenres() == null ? null : clobToString(details.getGenres()));
        dto.setLanguage(details.getLanguage() == null ? null : details.getLanguage());
        dto.setProductionCompanies(details.getProductionCompanies() == null ? null : clobToString(details.getProductionCompanies()));
        dto.setRating(details.getRating() < 0? null : details.getRating());

        return dto;
    }

    public String clobToString(Clob clob) throws SQLException, IOException {
        InputStream in = clob.getAsciiStream();
        StringWriter w = new StringWriter();
        IOUtils.copy(in, w);
        String s = w.toString();
        return s;
    }
}