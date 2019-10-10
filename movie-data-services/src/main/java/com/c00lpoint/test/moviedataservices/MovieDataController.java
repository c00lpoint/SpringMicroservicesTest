package com.c00lpoint.test.moviedataservices;

import com.c00lpoint.test.moviedataservices.modules.MovieInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@RestController
@RequestMapping("/movie")
public class MovieDataController {

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
