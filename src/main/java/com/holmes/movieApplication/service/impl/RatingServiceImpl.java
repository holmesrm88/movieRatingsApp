package com.holmes.movieApplication.service.impl;

import com.holmes.movieApplication.dto.movieDetail.MovieDetailsDTO;
import com.holmes.movieApplication.dto.rating.RatingDTO;
import com.holmes.movieApplication.model.movie.Movie;
import com.holmes.movieApplication.model.rating.MovieDetails;
import com.holmes.movieApplication.model.rating.Rating;
import com.holmes.movieApplication.repository.rating.RatingRepository;
import com.holmes.movieApplication.service.RatingService;
import com.holmes.movieApplication.util.converter.MovieDetailsDtoToMovieDetailConverter;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Service
@Log
public class RatingServiceImpl implements RatingService {

    RatingRepository ratingRepository;
    MovieDetailsDtoToMovieDetailConverter converter;

    @Autowired
    public RatingServiceImpl(RatingRepository ratingRepository){
        this.ratingRepository = ratingRepository;
    }

    @Override
    public MovieDetailsDTO getMovieDetails(String title) throws SQLException, IOException {
        log.info("RatingServiceImpl | getMovieDetails for "+title+" | START");
        MovieDetails details = ratingRepository.getMovieDetails(title);
        converter = new MovieDetailsDtoToMovieDetailConverter();
        MovieDetailsDTO dto = converter.coverter(details);
        log.info("RatingServiceImpl | getMovieDetails | END");
        return dto;
    }
}
