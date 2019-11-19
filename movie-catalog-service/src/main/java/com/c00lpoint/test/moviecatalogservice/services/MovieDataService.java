package com.c00lpoint.test.moviecatalogservice.services;

import com.c00lpoint.test.moviecatalogservice.modules.MovieInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieDataService {
    @Autowired
    private RestTemplate template;

    @HystrixCommand(fallbackMethod = "getFallbackMovieInfo")
    public MovieInfo getMovieInfo(long movieId){
        return template.getForObject("http://MOVIE-DATA-SERVICE/movie/" + movieId, MovieInfo.class);
    }

    public MovieInfo getFallbackMovieInfo(long movieId){
        MovieInfo fallbackObj = new MovieInfo();
        fallbackObj.setMovieId(movieId);
        return fallbackObj;
    }
}
