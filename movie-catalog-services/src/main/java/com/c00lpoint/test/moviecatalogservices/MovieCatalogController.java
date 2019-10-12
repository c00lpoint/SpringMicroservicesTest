package com.c00lpoint.test.moviecatalogservices;

import com.c00lpoint.test.moviecatalogservices.modules.MovieCatalogInfo;
import com.c00lpoint.test.moviecatalogservices.modules.MovieInfo;
import com.c00lpoint.test.moviecatalogservices.modules.RatingInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
    @Autowired
    private RestTemplate template;
    @Autowired
    private WebClient.Builder webClientBuilder;

    @RequestMapping("/{userId}")
    public List<MovieCatalogInfo> getMovieCatalog(@PathVariable("userId") String userId){

        //get object of list from RestfulService
        List<RatingInfo> ratingInfos = template.exchange(
                "http://localhost:8083/rating/user/" + userId,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<RatingInfo>>() {}).getBody();

        WebClient.Builder builder = WebClient.builder();

        return ratingInfos.stream().map(r -> {
            MovieInfo movieInfo = template.getForObject("http://localhost:8082/movie/" + r.getMovieId(), MovieInfo.class);

//            MovieInfo movieInfo = webClientBuilder.build()
//                    .get()
//                    .uri("http://localhost:8082/movie/" + r.getMovieId())
//                    .retrieve()
//                    .bodyToMono(MovieInfo.class)
//                    .block();

            return new MovieCatalogInfo(movieInfo.getName(), movieInfo.getDesc(), r.getRating());
        }).collect(Collectors.toList());

    }
}
