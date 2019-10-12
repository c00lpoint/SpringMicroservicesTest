package com.c00lpoint.test.ratingdataservices;

import com.c00lpoint.test.ratingdataservices.modules.RatingInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingDataController {

    List<RatingInfo> ratingInfos = Arrays.asList(
            new RatingInfo(1, 4.5),
            new RatingInfo(2, 4),
            new RatingInfo(3, 4),
            new RatingInfo(4, 4.7)
    );

    @RequestMapping("/{movieId}")
    public RatingInfo getRating(@PathVariable("movieId") long movieId){
        return new RatingInfo(movieId, 4.5);
    }

    @RequestMapping("/user/{userId}")
    public List<RatingInfo> getUserRatings(@PathVariable("userId") String userId){
        return ratingInfos;
    }
}
