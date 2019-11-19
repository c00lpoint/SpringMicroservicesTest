package com.c00lpoint.test.moviecatalogservice;

import com.c00lpoint.test.moviecatalogservice.modules.*;
import com.c00lpoint.test.moviecatalogservice.services.MovieDataService;
import com.c00lpoint.test.moviecatalogservice.services.RatingDataService;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
    @Autowired
    private WebClient.Builder webClientBuilder;
    @Autowired
    private RatingDataService ratingDataService;
    @Autowired
    private MovieDataService movieDataService;


//    @Autowired
//    private DiscoveryClient discoveryClient;

    @RequestMapping("/{userId}")
    public MovieCatalogList getMovieCatalog(@PathVariable("userId") String userId){
        //get object of list from RestfulService
//        List<RatingInfo> ratingInfos = template.exchange(
//                "http://localhost:8083/rating/user/" + userId,
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<List<RatingInfo>>() {}).getBody();
        UserRatings userRatings = ratingDataService.getUserRatings(userId);

        WebClient.Builder builder = WebClient.builder();

        List<MovieCatalogInfo> catalogList = userRatings.getRatings().stream().map(r -> {
            MovieInfo movieInfo = movieDataService.getMovieInfo(r.getMovieId());

//            MovieInfo movieInfo = webClientBuilder.build()
//                    .get()
//                    .uri("http://localhost:8082/movie/" + r.getMovieId())
//                    .retrieve()
//                    .bodyToMono(MovieInfo.class)
//                    .block();

            return new MovieCatalogInfo(movieInfo.getName(), movieInfo.getDesc(), r.getRating());
        }).collect(Collectors.toList());
        return new MovieCatalogList(catalogList);
    }

}
