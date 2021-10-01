package com.holmes.movieApplication.repository.movie;

import com.holmes.movieApplication.model.movie.Movie;
import com.holmes.movieApplication.model.movie.MovieByYear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

//    @Query(value = "SELECT imdbId, title, releaseDate, budget, genres FROM movies",
//            countQuery = "SELECT count(*), imdbId, title, releaseDate, budget, genres FROM movies",
//            nativeQuery = true)
//    List<Movie> findAllPagination(Pageable pageable);

//    @Query(value = "SELECT imdbId, title, releaseDate, budget, genres FROM movies",
//            countQuery = "SELECT count(*), imdbId, title, releaseDate, budget, genres FROM movies",
//            nativeQuery = true)
//    List<Movie> findAllByYear(int, year Pageable pageable);

    @Query(value = "SELECT new com.holmes.movieApplication.model.movie.MovieByYear(imdbId, title, releaseDate, budget, genres) FROM Movie WHERE SUBSTRING(releaseDate,0,4) > ?1")
    List<MovieByYear> findAllByYear(@Param("year") String year);

}
