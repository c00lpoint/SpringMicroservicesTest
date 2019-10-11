package com.c00lpoint.test.moviecatalogservices;

import com.c00lpoint.test.moviecatalogservices.modules.MovieCatalogInfo;
import com.c00lpoint.test.moviecatalogservices.modules.MovieInfo;
import com.c00lpoint.test.moviecatalogservices.modules.RatingInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
    @Autowired
    private RestTemplate template;

    @RequestMapping("/{userId}")
    public List<MovieCatalogInfo> getMovieCatalog(@PathVariable("userId") String userId){

        List<RatingInfo> ratingInfos = Arrays.asList(
                new RatingInfo(1, 4.5),
                new RatingInfo(2, 4),
                new RatingInfo(3, 4),
                new RatingInfo(4, 4.7)
        );

        return ratingInfos.stream().map(r -> {
            MovieInfo movieInfo = template.getForObject("http://localhost:8082/movie/" + r.getMovieId(), MovieInfo.class);
            return new MovieCatalogInfo(movieInfo.getName(), movieInfo.getDesc(), r.getRating());
        }).collect(Collectors.toList());

    }
}
