package com.c00lpoint.test.moviedataservices;

import com.c00lpoint.test.moviedataservices.modules.MovieInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieDataController {
    @RequestMapping("/{movieId}")
    public MovieInfo getMovieInfo(@PathVariable("movieId") long movieId){
        return new MovieInfo(movieId, "Avenger 4", "Endgame");
    }
}
