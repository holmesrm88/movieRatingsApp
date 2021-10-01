package com.holmes.movieApplication.service;

import com.holmes.movieApplication.dto.rating.RatingDTO;

public interface RatingService {
    RatingDTO getMovieDetails(String title);
}
