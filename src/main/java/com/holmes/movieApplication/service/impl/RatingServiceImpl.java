package com.holmes.movieApplication.service.impl;

import com.holmes.movieApplication.dto.movieDetail.MovieDetailsDTO;
import com.holmes.movieApplication.model.rating.MovieDetails;
import com.holmes.movieApplication.repository.rating.RatingRepository;
import com.holmes.movieApplication.service.RatingService;
import com.holmes.movieApplication.util.converter.MovieDetailsToMovieDetailDtoConverter;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Log
public class RatingServiceImpl implements RatingService {

    RatingRepository ratingRepository;
    MovieDetailsToMovieDetailDtoConverter converter;

    @Autowired
    public RatingServiceImpl(RatingRepository ratingRepository){
        this.ratingRepository = ratingRepository;
    }

    @Override
    public MovieDetailsDTO getMovieDetails(String title) {
        log.info("RatingServiceImpl | getMovieDetails for "+title+" | START");
        MovieDetails details = ratingRepository.getMovieDetails(title);
        converter = new MovieDetailsToMovieDetailDtoConverter();
        MovieDetailsDTO dto = converter.converter(details);
        log.info("RatingServiceImpl | getMovieDetails | END");
        return dto;
    }
}
