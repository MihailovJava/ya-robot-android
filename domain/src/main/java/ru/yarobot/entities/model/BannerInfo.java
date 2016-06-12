package ru.yarobot.entities.model;

import lombok.Data;

@Data
public class BannerInfo {

    private String id;
    private String seriesId;
    private long bannerId;
    private int campaignId;
    private long phraseId;
    private Float price;
    private Action action;
    private Position position;
    private Status status;
    private String statusMessage;


}