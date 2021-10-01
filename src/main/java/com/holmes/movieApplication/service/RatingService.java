package com.holmes.movieApplication.service;

import com.holmes.movieApplication.dto.movieDetail.MovieDetailsDTO;


import java.io.IOException;
import java.sql.SQLException;

public interface RatingService {
    MovieDetailsDTO getMovieDetails(String title) throws SQLException, IOException;
}
