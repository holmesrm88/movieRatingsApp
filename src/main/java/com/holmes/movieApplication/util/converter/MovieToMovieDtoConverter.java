package com.holmes.movieApplication.util.converter;

import com.holmes.movieApplication.dto.movie.MovieDTO;
import com.holmes.movieApplication.model.movie.Movie;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.sql.Clob;
import java.sql.SQLException;

public class MovieToMovieDtoConverter {

    public MovieDTO converter(Movie movie) throws SQLException, IOException {
        MovieDTO movieDTO = new MovieDTO();

        movieDTO.setBudget(movie.getBudget() == null ? null : "$"+movie.getBudget());
        movieDTO.setGenres(movie.getGenres() == null ? null : clobToString(movie.getGenres()));
        movieDTO.setImdbId(movie.getImdbId() == null ? null : movie.getImdbId());
//        movieDTO.setLanguage(dto.getLanguage() == null ? null : dto.getLanguage());
//        movieDTO.setOverview(dto.getOverview() == null ? null : clobToString(dto.getOverview()));
//        movieDTO.setRevenue(dto.getRevenue() == null ? null : dto.getRevenue());
//        movieDTO.setRuntime(dto.getRuntime() == null ? null : dto.getRuntime());
        movieDTO.setReleaseDate(movie.getReleaseDate() == null ? null : movie.getReleaseDate());
//        movieDTO.setProductionCompanies(dto.getProductionCompanies() == null ? null :  clobToString(dto.getProductionCompanies()));
//        movieDTO.setStatus(dto.getStatus() == null ? null : dto.getStatus());
        movieDTO.setTitle(movie.getTitle() == null ? null : movie.getTitle());

        return movieDTO;
    }

    public String clobToString(Clob clob) throws SQLException, IOException {
        InputStream in = clob.getAsciiStream();
        StringWriter w = new StringWriter();
        IOUtils.copy(in, w);
        String s = w.toString();
        return s;
    }
}
