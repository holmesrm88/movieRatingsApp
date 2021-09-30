//package com.holmes.movieApplication.configuration;
//
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//
//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class MoviesConfig {
//
////    @Bean
////    @Primary
////    @ConfigurationProperties(prefix = "spring.ds_movies")
////    public DataSourceProperties moviesDataSourceProperties(){
////        return new DataSourceProperties();
////    }
//
//    @Bean(name = "ds_movies")
//    @ConfigurationProperties(prefix = "spring.ds_movies")
//    public DataSource moviesDataSource(){
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "ds_moviesJdbcTemplate")
//    public Jd
//
//
//}
