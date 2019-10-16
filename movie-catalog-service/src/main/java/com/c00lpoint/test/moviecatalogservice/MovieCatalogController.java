package com.c00lpoint.test.moviecatalogservice;

import com.c00lpoint.test.moviecatalogservice.modules.MovieCatalogInfo;
import com.c00lpoint.test.moviecatalogservice.modules.MovieInfo;
import com.c00lpoint.test.moviecatalogservice.modules.UserRatings;
import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

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
    public List<MovieCatalogInfo> getMovieCatalog(@PathVariable("userId") String userId){
        //get object of list from RestfulService
//        List<RatingInfo> ratingInfos = template.exchange(
//                "http://localhost:8083/rating/user/" + userId,
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<List<RatingInfo>>() {}).getBody();
        UserRatings userRatings = template.getForObject("http://RATING-DATA-SERVICE/rating/user/" + userId, UserRatings.class);

        WebClient.Builder builder = WebClient.builder();

        return userRatings.getRatings().stream().map(r -> {
            MovieInfo movieInfo = template.getForObject("http://MOVIE-DATA-SERVICE/movie/" + r.getMovieId(), MovieInfo.class);

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
