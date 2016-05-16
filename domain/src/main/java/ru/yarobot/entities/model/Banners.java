package ru.yarobot.entities.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Banners {
    @JsonProperty("data")
    List<Banner> banners;

    public List<Banner> getBanners() {
        return banners;
    }
}
