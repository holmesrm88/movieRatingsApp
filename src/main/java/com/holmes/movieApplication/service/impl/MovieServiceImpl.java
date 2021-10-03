package com.holmes.movieApplication.service.impl;

import com.holmes.movieApplication.dto.MovieByYear.MovieByYearDTO;
import com.holmes.movieApplication.dto.movie.MovieDTO;
import com.holmes.movieApplication.model.movie.Movie;
import com.holmes.movieApplication.model.movie.MovieByYear;
import com.holmes.movieApplication.repository.movie.MovieRepository;
import com.holmes.movieApplication.service.MovieService;
import com.holmes.movieApplication.util.converter.MovieByYearToMovieByYearDtoConverter;
import com.holmes.movieApplication.util.converter.MovieToMovieDtoConverter;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Log
public class MovieServiceImpl implements MovieService {

    MovieRepository movieRepository;
    MovieByYearToMovieByYearDtoConverter movieByYearDtoConverter;
    MovieToMovieDtoConverter movieToMovieDtoConverter;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<MovieDTO> getAllMovies(int page) {
        log.info("MovieServiceImpl | getAllMovies | Start");
        Pageable pageable = PageRequest.of(page, 10);
        Page<Movie> movies = movieRepository.findAll(pageable);
        List<MovieDTO> movieDTOS = new ArrayList<>();
        movieToMovieDtoConverter = new MovieToMovieDtoConverter();
        for(Movie m : movies){
            MovieDTO movie = new MovieDTO();
            movie = movieToMovieDtoConverter.converter(m);
            movieDTOS.add(movie);
        }
        log.info("MovieServiceImpl | getAllMovies returning " +movieDTOS.size() +" | END");
        if(movieDTOS.size() == 0){
            throw new NoSuchElementException();
        }
        return movieDTOS;
    }

    @Override
    public List<MovieByYearDTO> getMoviesByYear(String year, int page){
        log.info("MovieServiceImpl | getMoviesByYear | Start");
        Pageable pageable = PageRequest.of(page, 25, Sort.by("releaseDate").descending());
        List<MovieByYear> newMoviesMethod = movieRepository.findAllByYear(year);
        List<MovieByYearDTO> movieDTOS = new ArrayList<>();
        movieByYearDtoConverter = new MovieByYearToMovieByYearDtoConverter();
            for(MovieByYear m : newMoviesMethod) {
                MovieByYearDTO movie = new MovieByYearDTO();
                movie = movieByYearDtoConverter.converter(m);
                movieDTOS.add(movie);
            }
        log.info("MovieServiceImpl | getMoviesByYear returning " +movieDTOS.size() +" for year " +year+" | END");
        if(movieDTOS.size() == 0){
            throw new NoSuchElementException("No movies returned for year " + year);
        }
        return movieDTOS;
    }

    @Override
    public List<MovieDTO> getMoviesByGenre(String genre) {
        return null;
    }
}