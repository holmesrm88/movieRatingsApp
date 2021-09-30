package com.holmes.movieApplication.service.serviceImpl;

import com.holmes.movieApplication.dto.MovieDTO;
import com.holmes.movieApplication.repository.MovieRepository;
import com.holmes.movieApplication.service.MovieService;
import com.holmes.movieApplication.util.Connect;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
@Log
public class MovieServiceImpl implements MovieService {

    MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @Override
    public List<MovieDTO> getAllMovies() throws SQLException {
        log.info("MovieServiceImpl | getAllMovies | Start");
        ResultSet rs = movieRepository.getAllMovies();
        while(rs.next()){
            System.out.println("name: " + rs.getString("title") + " | rating: " + rs.getString("rating"));
        }
        Connect.close();
        return null;
    }

    @Override
    public MovieDTO getMovieDetails(String title) throws SQLException {
        log.info("MovieServiceImpl | getMovieDetails | Start");
        ResultSet rs = movieRepository.getMovie(title);
        while(rs.next()){
            System.out.println("name: " + rs.getString("title") + " | rating: " + rs.getString("rating"));
        }
        //Connect.close();

        return null;
    }

    @Override
    public List<MovieDTO> getMoviesByYear(String year) {
        return null;
    }

    @Override
    public List<MovieDTO> getMoviesByGenre(String genre) {
        return null;
    }
}
