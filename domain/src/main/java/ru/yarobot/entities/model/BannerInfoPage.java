package ru.yarobot.entities.model;

import java.util.List;

public class BannerInfoPage {
    private List<BannerInfo> banners;
    private String next;
    private Integer totalPages;

    public BannerInfoPage(List<BannerInfo> banners, String next, Integer totalPages) {
        this.banners = banners;
        this.next = next;
        this.totalPages = totalPages;
    }

    public List<BannerInfo> getBanners() {
        return banners;
    }

    public String getNext() {
        return next;
    }

    public Integer getTotalPages() {
        return totalPages;
    }
}
