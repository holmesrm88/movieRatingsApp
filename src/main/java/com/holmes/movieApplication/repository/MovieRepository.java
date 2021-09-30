package com.holmes.movieApplication.repository;

import com.holmes.movieApplication.dto.MovieDTO;
import com.holmes.movieApplication.util.Connect;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepository {
    String sql;
    Statement st;
    ResultSet rs;

    public ResultSet getAllMovies() throws SQLException {
        sql = "Select * FROM movies";
        //st = Connect.connect().createStatement();
        rs = st.executeQuery(sql);
        return rs;
    }

    public ResultSet getMovie(String title) throws SQLException {
        sql = "SELECT \n" +
                "    m.title,\n" +
                "    r.rating\n" +
                "FROM movies m\n" +
                "JOIN ratings r on r.movieId = m.movieId;\n" +
                "WHERE m.title =" + title;
       // st = Connect.connect().createStatement();
        rs = st.executeQuery(sql);
        return rs;
    }
}
