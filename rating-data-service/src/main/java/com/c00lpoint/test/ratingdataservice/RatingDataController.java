package com.c00lpoint.test.ratingdataservice;

import com.c00lpoint.test.ratingdataservice.modules.RatingInfo;
import com.c00lpoint.test.ratingdataservice.modules.UserRatings;
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

    // Since backward compatibility reason do not use list as the root object of the result .
    @RequestMapping("/user/{userId}")
    public UserRatings getUserRatings(@PathVariable("userId") String userId){
        return new UserRatings(userId, ratingInfos);
    }
}
