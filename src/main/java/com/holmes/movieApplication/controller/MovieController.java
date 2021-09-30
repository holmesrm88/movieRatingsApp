package com.holmes.movieApplication.controller;

import com.holmes.movieApplication.dto.MovieDTO;
import com.holmes.movieApplication.service.MovieService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@ComponentScan
@RestController
@Log
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/getAllMovies")
    public List<MovieDTO> getAllMovies() throws SQLException {
        movieService.getAllMovies();
        return null;
    }

    @GetMapping("/getMovieDetails/{movieTitle}")
    public MovieDTO getMovieDetails(@PathVariable String movieTitle) throws SQLException {
        movieService.getMovieDetails(movieTitle);
        return null;
    }

    @GetMapping("/getMovies/{year}")
    public List<MovieDTO> getMoviesByYear(@PathVariable String year){
        return null;
    }

    @GetMapping("/getMovies/genre/{genre}")
    public List<MovieDTO> getMoviesByGenre(@PathVariable String genre){
        return null;
    }


}
