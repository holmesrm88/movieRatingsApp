package com.holmes.movieApplication.controller;

import com.holmes.movieApplication.dto.movie.MovieDTO;
import com.holmes.movieApplication.dto.movieDetail.MovieDetailsDTO;
import com.holmes.movieApplication.dto.rating.RatingDTO;
import com.holmes.movieApplication.model.rating.MovieDetails;
import com.holmes.movieApplication.service.MovieService;
import com.holmes.movieApplication.service.RatingService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@ComponentScan
@RestController
@Log
public class movieController {
    @Autowired
    MovieService movieService;

    @Autowired
    RatingService ratingService;

    @GetMapping("/getAllMovies/{page}")
    public ResponseEntity getAllMovies(@PathVariable("page") int page) throws SQLException, IOException {
        List<MovieDTO> movies = movieService.getAllMovies(page);
        if (movies.size() > 0) {
            return new ResponseEntity(movies, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getMovieDetails/{movieTitle}")
    public MovieDetailsDTO getMovieDetails(@PathVariable String movieTitle) throws SQLException, IOException {
        return ratingService.getMovieDetails(movieTitle);
    }

    @GetMapping("/getMovies/{year}/{page}")
    public ResponseEntity getMoviesByYear(@PathVariable("year") String year, @PathVariable("page") int page ) throws SQLException, IOException {
        List<MovieDTO> movies = movieService.getMoviesByYear(year, page);
        if(movies.size() > 0){
            return new ResponseEntity(movies, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getMovies/genre/{genre}")
    public List<MovieDTO> getMoviesByGenre(@PathVariable String genre){
        return null;
    }
}
