package com.holmes.movieApplication.dto.rating;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class RatingDTO {

    private Integer ratingId;
    private Integer userId;
    private Integer movieId;
    private double rating;
    private Integer timestamp;
}
