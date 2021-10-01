package com.holmes.movieApplication.repository.rating;

import com.holmes.movieApplication.dto.rating.RatingDTO;
import com.holmes.movieApplication.model.rating.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

//    @Query(value = "SELECT \n" +
//            "* \n" +
//            "FROM \n" +
//            "RATINGS r\n" +
//            "JOIN MOVIES m on m.movieid = r.movieid\n" +
//            "WHERE m.title = ?1")
//    RatingDTO getMovieDetails(String title);
}
