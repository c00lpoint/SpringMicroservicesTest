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
            new RatingInfo(24428, 3.8),
            new RatingInfo(99861, 3.7),
            new RatingInfo(299536, 4.2),
            new RatingInfo(299534, 4.2)
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
