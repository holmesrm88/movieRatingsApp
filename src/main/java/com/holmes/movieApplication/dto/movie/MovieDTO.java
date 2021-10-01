package com.holmes.movieApplication.dto.movie;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.sql.Clob;
import java.util.HashMap;
import java.util.Map;

@Data
@Getter
@Setter
public class MovieDTO {

    private String imdbId;
    private String title;
    private String releaseDate;
    private String budget;
    private String genres;

}
