package com.holmes.movieApplication.util;

import lombok.extern.java.Log;

import java.sql.*;

@Log
public class Connect {
    public static Connection moviesConnection;
    public static Connection ratingsConnection;
    public static Connection connect(){
        moviesConnection = null;
        try {
            String movies = "jdbc:sqlite:/Users/matt-macbook/Documents/workspace/java/movieApplication/movies.db";
            String ratings = "jdbc:sqlite:/Users/matt-macbook/Documents/workspace/java/movieApplication/ratings.db";

            String moviesPath = "/Users/matt-macbook/Documents/workspace/java/movieApplication/movies.db";
            String ratingsPath = "/Users/matt-macbook/Documents/workspace/java/movieApplication/ratings.db";

            moviesConnection = DriverManager.getConnection(movies);
            ratingsConnection = DriverManager.getConnection(ratings);

            moviesConnection.prepareStatement("ATTACH DATABASE\"" + moviesPath + "\" AS m").execute();
            moviesConnection.prepareStatement("ATTACH DATABASE\"" + ratingsPath + "\" AS r").execute();

            //connNewDb.prepareStatement("ATTACH DATABASE \"" + connOldDb + "\" AS  fromDB").execute();


//            String sql = "Select * FROM movies LIMIT 1";
//            Statement st = connection.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//
//            while(rs.next()){
//                System.out.println("title: " + rs.getString("title"));
//            }

            log.info("Connection | connect | Connection to SQLite has been established.");
        } catch (SQLException throwables) {
            log.info("Connection | connect | SQLException thrown establishing connection: ");
            throwables.printStackTrace();
        }
//        finally {
//            try {
//                if(connection != null){
//                    connection.close();
//                }
//            } catch (SQLException throwables) {
//                log.info("Connection | connect | SQLException thrown closing connection");
//                throwables.printStackTrace();
//            }
//        }
        return moviesConnection;
    }

    public static void close(){
        try {
                if(moviesConnection != null){
                    moviesConnection.close();
                }
            } catch (SQLException throwables) {
                log.info("Connection | connect | SQLException thrown closing connection");
                throwables.printStackTrace();
            }
    }
}
