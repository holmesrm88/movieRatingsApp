package com.holmes.movieApplication.controller;

import com.holmes.movieApplication.dto.movie.MovieDTO;
import com.holmes.movieApplication.dto.movieDetail.MovieDetailsDTO;
import com.holmes.movieApplication.service.MovieService;
import com.holmes.movieApplication.service.RatingService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ComponentScan
@RestController
@Log
public class MovieController {

    MovieService movieService;
    RatingService ratingService;

    @Autowired
    public MovieController(RatingService ratingService, MovieService movieService){
        this.ratingService = ratingService;
        this.movieService =movieService;
    }

    @GetMapping("/getAllMovies/{page}")
    public ResponseEntity getAllMovies(@PathVariable("page") int page)  {
            return new ResponseEntity(movieService.getAllMovies(page), HttpStatus.OK);
    }

    @GetMapping("/getMovieDetails/{movieTitle}")
    public MovieDetailsDTO getMovieDetails(@PathVariable String movieTitle) {
        return ratingService.getMovieDetails(movieTitle);
    }

    @GetMapping("/getMovies/{year}/{page}")
    public ResponseEntity getMoviesByYear(@PathVariable("year") String year, @PathVariable("page") int page ) {
        return new ResponseEntity(movieService.getMoviesByYear(year, page), HttpStatus.OK);
    }

    @GetMapping("/getMovies/genre/{genre}")
    public List<MovieDTO> getMoviesByGenre(@PathVariable String genre){
        return null;
    }
}
