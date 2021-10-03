package com.holmes.movieApplication.service;

import com.holmes.movieApplication.dto.movieDetail.MovieDetailsDTO;

public interface RatingService {
    MovieDetailsDTO getMovieDetails(String title);
}
