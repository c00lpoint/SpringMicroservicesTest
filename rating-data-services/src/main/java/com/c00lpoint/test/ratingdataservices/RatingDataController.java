package com.c00lpoint.test.ratingdataservices;

import com.c00lpoint.test.ratingdataservices.modules.RatingInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rating")
public class RatingDataController {

    @RequestMapping("/{movieId}")
    public RatingInfo getRating(@PathVariable("movieId") long movieId){
        return new RatingInfo(movieId, 4.5);
    }
}
