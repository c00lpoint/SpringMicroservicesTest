package com.c00lpoint.test.moviecatalogservice;

import com.c00lpoint.test.moviecatalogservice.modules.MovieCatalogInfo;
import com.c00lpoint.test.moviecatalogservice.modules.MovieCatalogList;
import com.c00lpoint.test.moviecatalogservice.modules.MovieInfo;
import com.c00lpoint.test.moviecatalogservice.modules.UserRatings;
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
    private RestTemplate template;
    @Autowired
    private WebClient.Builder webClientBuilder;

//    @Autowired
//    private DiscoveryClient discoveryClient;

    @RequestMapping("/{userId}")
    @HystrixCommand(fallbackMethod = "getFallbackCatalogList")
    public MovieCatalogList getMovieCatalog(@PathVariable("userId") String userId){
        //get object of list from RestfulService
//        List<RatingInfo> ratingInfos = template.exchange(
//                "http://localhost:8083/rating/user/" + userId,
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<List<RatingInfo>>() {}).getBody();
        UserRatings userRatings = template.getForObject("http://RATING-DATA-SERVICE/rating/user/" + userId, UserRatings.class);

        WebClient.Builder builder = WebClient.builder();

        List<MovieCatalogInfo> catalogList = userRatings.getRatings().stream().map(r -> {
            MovieInfo movieInfo = template.getForObject("http://MOVIE-DATA-SERVICE/movie/" + r.getMovieId(), MovieInfo.class);

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

    public  MovieCatalogList getFallbackCatalogList(String userId){
        return new MovieCatalogList(Arrays.asList(
           new MovieCatalogInfo("/", "/", 0)
        ));
    }
}
