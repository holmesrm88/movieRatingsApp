package com.holmes.movieApplication.repository.rating;

import com.holmes.movieApplication.dto.rating.RatingDTO;
import com.holmes.movieApplication.model.rating.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

//    @Query(value = "SELECT\n" +
//            "m.imdbid,\n" +
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
//            "JOIN Movies m on r.movieid = m.movieid\n" +
//            "WHERE m.title = ?1")
//    RatingDTO getMovieDetails(String title);
}
