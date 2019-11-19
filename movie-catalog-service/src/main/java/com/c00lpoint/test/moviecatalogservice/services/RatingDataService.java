package com.c00lpoint.test.moviecatalogservice.services;

import com.c00lpoint.test.moviecatalogservice.modules.UserRatings;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class RatingDataService {
    @Autowired
    private RestTemplate template;

    @HystrixCommand(fallbackMethod = "getFallbackUserRatings")
    public UserRatings getUserRatings(String userId){
        return  template.getForObject("http://RATING-DATA-SERVICE/rating/user/" + userId, UserRatings.class);
    }

    public UserRatings getFallbackUserRatings(String userId){
        UserRatings fallbackObj = new UserRatings();
        fallbackObj.setRatings(Arrays.asList());
        return fallbackObj;
    }

}
