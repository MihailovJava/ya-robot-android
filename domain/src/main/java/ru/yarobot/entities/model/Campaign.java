package ru.yarobot.entities.model;

import com.fasterxml.jackson.annotation.JsonProperty;



import java.util.Date;

public class Campaign {
    @JsonProperty("CampaignID")
    private int campaignID;
    @JsonProperty("Login")
    private String login;
    @JsonProperty("Name")
    private String name;

    @JsonProperty("StartDate")
    private Long startDate;

    @JsonProperty("Sum")
    private float sum;
    @JsonProperty("Rest")
    private float rest;
    @JsonProperty("SumAvailableForTransfer")
    private float sumAvailableForTransfer;
    @JsonProperty("Shows")
    private int shows;
    @JsonProperty("Clicks")
    private int clicks;
    @JsonProperty("Status")
    private String status;
    @JsonProperty("StatusShow")
    private String statusShow;
    @JsonProperty("StatusArchive")
    private String statusArchive;
    @JsonProperty("StatusActivating")
    private String statusActivating;
    @JsonProperty("StatusModerate")
    private String statusModerate;
    @JsonProperty("IsActive")
    private String isActive;
    @JsonProperty("ManagerName")
    private String managerName;
    @JsonProperty("AgencyName")
    private String agencyName;

    public int getCampaignID() {
        return campaignID;
    }

    public String getIsActive() {
        return isActive;
    }

    public String getStatus() {
        return status;
    }
}
