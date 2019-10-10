package com.c00lpoint.test.moviecatalogservices;

import com.c00lpoint.test.moviecatalogservices.modules.MovieCatalogInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
    @RequestMapping("/{userId}")
    public List<MovieCatalogInfo> getMovieCatalog(@PathVariable("userId") String userId){
        return Collections.singletonList(new MovieCatalogInfo("The Avengers 4", "Endgame", 4.5));
    }
}
