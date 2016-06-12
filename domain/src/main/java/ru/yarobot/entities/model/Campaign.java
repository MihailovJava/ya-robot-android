package ru.yarobot.entities.model;


import com.google.gson.annotations.SerializedName;

public class Campaign {
    @SerializedName("CampaignID")
    private int campaignID;
    @SerializedName("Login")
    private String login;
    @SerializedName("Name")
    private String name;

    @SerializedName("StartDate")
    private Long startDate;

    @SerializedName("Sum")
    private float sum;
    @SerializedName("Rest")
    private float rest;
    @SerializedName("SumAvailableForTransfer")
    private float sumAvailableForTransfer;
    @SerializedName("Shows")
    private int shows;
    @SerializedName("Clicks")
    private int clicks;
    @SerializedName("Status")
    private String status;
    @SerializedName("StatusShow")
    private String statusShow;
    @SerializedName("StatusArchive")
    private String statusArchive;
    @SerializedName("StatusActivating")
    private String statusActivating;
    @SerializedName("StatusModerate")
    private String statusModerate;
    @SerializedName("IsActive")
    private String isActive;
    @SerializedName("ManagerName")
    private String managerName;
    @SerializedName("AgencyName")
    private String agencyName;

    private CampaignInfo campaignInfo;

    public int getCampaignID() {
        return campaignID;
    }

    public String getIsActive() {
        return isActive;
    }

    public String getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CampaignInfo getCampaignInfo() {
        return campaignInfo;
    }

    public void setCampaignInfo(CampaignInfo campaignInfo) {
        this.campaignInfo = campaignInfo;
    }
}
