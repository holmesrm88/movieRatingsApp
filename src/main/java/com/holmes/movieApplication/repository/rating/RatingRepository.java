package com.holmes.movieApplication.repository.rating;

import com.holmes.movieApplication.model.rating.MovieDetails;
import com.holmes.movieApplication.model.rating.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {

    @Query(value = "            SELECT\n" +
            "            new com.holmes.movieApplication.model.rating.MovieDetails(\n" +
            "            AVG(r.rating),\n" +
            "            m.imdbId, \n" +
            "           m.title,\n" +
            "           m.overview,\n" +
            "            m.releaseDate,\n" +
            "            m.budget,\n" +
            "            m.runtime,\n" +
            "            m.genres,\n" +
            "            m.language,\n" +
            "            m.productionCompanies)\n" +
            "            FROM Rating r\n" +
            "            JOIN Movie m on r.movieId = m.movieId\n" +
            "            WHERE m.title = ?1 ")
    MovieDetails getMovieDetails(@Param("title") String title);


//    @Query(value = "SELECT\n" +
//            "m.imdbid, \n" +
//            "m.title,\n" +
//            "m.overview,\n" +
//            "m.releasedate,\n" +
//            "m.budget,\n" +
//            "m.runtime,\n" +
//            "m.genres,\n" +
//            "m.language,\n" +
//            "m.productioncompanies,\n" +
//            "AVG(r.rating)\n" +
//            "FROM ratings r\n" +
//            "JOIN movies m on r.movieid = m.movieid\n" +
//            "WHERE m.title = ?1",nativeQuery = true)
}
