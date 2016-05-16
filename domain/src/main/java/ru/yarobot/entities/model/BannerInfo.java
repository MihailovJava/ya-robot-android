package ru.yarobot.entities.model;



import java.util.Date;


public class BannerInfo {


    private String id;

    private Long date;
    private String seriesId;
    private Banner banner;
    private Float price;
    private Action action;
    private Position position;

    public Banner getBanner() {
        return banner;
    }

    public void setBanner(Banner banner) {
        this.banner = banner;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public String getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }

    @Override
    public String toString() {
        return  "Banner=" + banner.getBannerID() + " price=" + price + " action=" + action + " position=" + position;
    }
}