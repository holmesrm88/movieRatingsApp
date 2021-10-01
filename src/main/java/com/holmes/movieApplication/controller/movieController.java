package com.holmes.movieApplication.controller;

import com.holmes.movieApplication.dto.movie.MovieDTO;
import com.holmes.movieApplication.dto.rating.RatingDTO;
import com.holmes.movieApplication.service.MovieService;
import com.holmes.movieApplication.service.RatingService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
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
    public List<MovieDTO> getAllMovies(@PathVariable("page") int page) throws SQLException, IOException {
        return movieService.getAllMovies(page);
    }

    @GetMapping("/getMovieDetails/{movieTitle}")
    public RatingDTO getMovieDetails(@PathVariable String movieTitle) {
        return ratingService.getMovieDetails(movieTitle);
    }

    @GetMapping("/getMovies/{year}/{page}")
    public List<MovieDTO> getMoviesByYear(@PathVariable("year") String year, @PathVariable("page") int page ) throws SQLException, IOException {
        return movieService.getMoviesByYear(year, page);
    }

    @GetMapping("/getMovies/genre/{genre}")
    public List<MovieDTO> getMoviesByGenre(@PathVariable String genre){
        return null;
    }
}
