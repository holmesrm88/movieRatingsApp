package com.holmes.movieApplication.service.impl;

import com.holmes.movieApplication.dto.movie.MovieDTO;
import com.holmes.movieApplication.model.movie.Movie;
import com.holmes.movieApplication.repository.movie.MovieRepository;
import com.holmes.movieApplication.service.MovieService;
import com.holmes.movieApplication.util.FilterOutByYear;
import com.holmes.movieApplication.util.converter.MovieToMovieDtoConverter;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
@Log
public class MovieServiceImpl implements MovieService {

    MovieRepository movieRepository;
    MovieToMovieDtoConverter converter;
    FilterOutByYear filterOutByYear;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<MovieDTO> getAllMovies(int page) throws SQLException, IOException {
        log.info("MovieServiceImpl | getAllMovies | Start");
        Pageable pageable = PageRequest.of(1, page);
        Page<Movie> movies = movieRepository.findAll(pageable);
        List<Movie> mov = movies.toList();
        List<Movie> me = movies.getContent();
//        List<Movie> movies = movieRepository.findAll();
        List<MovieDTO> movieDTOS = new ArrayList<>();
        converter = new MovieToMovieDtoConverter();
        for(Movie m : movies){
            MovieDTO movie = new MovieDTO();
            movie = converter.converter(m);
            movieDTOS.add(movie);
        }
        log.info("MovieServiceImpl | getAllMovies returning " +movieDTOS.size() +" | END");
        return movieDTOS;
    }

    @Override
    public MovieDTO getMovieDetails(String title) {
        log.info("MovieServiceImpl | getMovieDetails | Start");
        return null;
    }

    //TODO need to filter by year
    @Override
    public List<MovieDTO> getMoviesByYear(String year, int page) throws SQLException, IOException {
        log.info("MovieServiceImpl | getMoviesByYear | Start");
        Pageable pageable = PageRequest.of(1, page, Sort.by("releaseDate").descending());
        Page<Movie> movies = movieRepository.findAll(pageable);
        List<MovieDTO> movieDTOS = new ArrayList<>();
        converter = new MovieToMovieDtoConverter();
        filterOutByYear = new FilterOutByYear();
        for(Movie m : movies) {
            MovieDTO movie = new MovieDTO();
            movie = converter.converter(m);
            movieDTOS.add(movie);
        }
        movieDTOS = filterOutByYear.filterMoviesByYear(movieDTOS, year);
        log.info("MovieServiceImpl | getMoviesByYear returning " +movieDTOS.size() +" | END");
        return movieDTOS;
    }

    @Override
    public List<MovieDTO> getMoviesByGenre(String genre) {
        return null;
    }
}