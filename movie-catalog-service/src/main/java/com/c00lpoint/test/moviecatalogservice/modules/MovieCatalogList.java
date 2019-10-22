package com.c00lpoint.test.moviecatalogservice.modules;

import java.util.List;

public class MovieCatalogList {
    private List<MovieCatalogInfo> catalogList;

    public MovieCatalogList() {
    }

    public MovieCatalogList(List<MovieCatalogInfo> catalogList) {
        this.catalogList = catalogList;
    }

    public List<MovieCatalogInfo> getCatalogList() {
        return catalogList;
    }

    public void setCatalogList(List<MovieCatalogInfo> catalogList) {
        this.catalogList = catalogList;
    }
}
