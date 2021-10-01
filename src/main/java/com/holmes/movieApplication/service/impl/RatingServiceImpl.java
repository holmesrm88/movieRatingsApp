package com.holmes.movieApplication.service.impl;

import com.holmes.movieApplication.dto.rating.RatingDTO;
import com.holmes.movieApplication.repository.rating.RatingRepository;
import com.holmes.movieApplication.service.RatingService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log
public class RatingServiceImpl implements RatingService {

    RatingRepository ratingRepository;

    @Autowired
    public RatingServiceImpl(RatingRepository ratingRepository){
        this.ratingRepository = ratingRepository;
    }

    @Override
    public RatingDTO getMovieDetails(String title) {
        log.info("RatingServiceImpl | getMovieDetails for "+title+" | START");
        RatingDTO ratingDTO = new RatingDTO();
        //ratingDTO = ratingRepository.getMovieDetails(title);
        log.info("RatingServiceImpl | getMovieDetails | END");
        return ratingDTO;
    }
}
