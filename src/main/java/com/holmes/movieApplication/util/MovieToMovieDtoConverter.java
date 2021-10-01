package com.holmes.movieApplication.util;

import com.holmes.movieApplication.dto.movie.MovieDTO;
import com.holmes.movieApplication.model.movie.Movie;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.sql.Clob;
import java.sql.SQLException;

public class MovieToMovieDtoConverter {

    public MovieDTO converter(Movie dto) throws SQLException, IOException {
        MovieDTO movieDTO = new MovieDTO();

        movieDTO.setBudget(dto.getBudget() == null ? null : "$"+dto.getBudget());
        movieDTO.setGenres(dto.getGenres() == null ? null : clobToString(dto.getGenres()));
        movieDTO.setImdbId(dto.getImdbId() == null ? null : dto.getImdbId());
//        movieDTO.setLanguage(dto.getLanguage() == null ? null : dto.getLanguage());
//        movieDTO.setOverview(dto.getOverview() == null ? null : clobToString(dto.getOverview()));
//        movieDTO.setRevenue(dto.getRevenue() == null ? null : dto.getRevenue());
//        movieDTO.setRuntime(dto.getRuntime() == null ? null : dto.getRuntime());
        movieDTO.setReleaseDate(dto.getReleaseDate() == null ? null : dto.getReleaseDate());
//        movieDTO.setProductionCompanies(dto.getProductionCompanies() == null ? null :  clobToString(dto.getProductionCompanies()));
//        movieDTO.setStatus(dto.getStatus() == null ? null : dto.getStatus());
        movieDTO.setTitle(dto.getTitle() == null ? null : dto.getTitle());

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
