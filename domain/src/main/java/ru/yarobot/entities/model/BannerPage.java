package ru.yarobot.entities.model;

import java.util.List;

public class BannerPage {
    private List<Banner> banners;
    private String next;
    private Integer totalPages;

    public BannerPage(List<Banner> banners, String next, Integer totalPages) {
        this.banners = banners;
        this.next = next;
        this.totalPages = totalPages;
    }

    public List<Banner> getBanners() {
        return banners;
    }

    public String getNext() {
        return next;
    }

    public Integer getTotalPages() {
        return totalPages;
    }
}