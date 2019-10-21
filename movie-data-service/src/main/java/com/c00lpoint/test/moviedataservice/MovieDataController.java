package com.c00lpoint.test.moviedataservice;

import com.c00lpoint.test.moviedataservice.modules.MovieInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@RestController
@RequestMapping("/movie")
public class MovieDataController {

    //call the tmdb api with https://api.themoviedb.org/3/movie/299536?api_key=02f3c125eb4f47a6f1daf49c91650b14
    private static final HashMap<Long, String> destMap = new HashMap<Long, String>(){{
        put(1l, "The Avengers");
        put(2l, "Age of Ultron");
        put(3l, " Infinity War");
        put(4l, "Endgame");
    }};

    @RequestMapping("/{movieId}")
    public MovieInfo getMovieInfo(@PathVariable("movieId") long movieId){
        return new MovieInfo(movieId, "Avenger " + movieId, destMap.get(movieId));
    }
}
