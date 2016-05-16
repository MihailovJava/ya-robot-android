package ru.yarobot.entities.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;



public class Banner {
    @JsonProperty("BannerID")
    private long bannerID;
    @JsonProperty("CampaignID")
    private int campaignID;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("Text")
    private String text;
    @JsonProperty("Href")
    private String href;
    @JsonProperty("Domain")
    private String domain;
    @JsonProperty("Geo")
    private String geo;
    @JsonProperty("StatusActivating")
    private String statusActivating;
    @JsonProperty("StatusArchive")
    private String statusArchive;
    @JsonProperty("StatusBannerModerate")
    private String statusBannerModerate;
    @JsonProperty("StatusPhrasesModerate")
    private String statusPhrasesModerate;
    @JsonProperty("StatusPhoneModerate")
    private String statusPhoneModerate;
    @JsonProperty("StatusShow")
    private String statusShow;
    @JsonProperty("IsActive")
    private String isActive;
    @JsonProperty("StatusSitelinksModerate")
    private String statusSiteLinksModerate;
    @JsonProperty("FixedOnModeration")
    private String fixedOnModeration;
    @JsonProperty("Phrases")
    private List<Phrase> phrases;

    public List<Phrase> getPhrases() {
        return phrases;
    }

    public String getDomain() {
        return domain;
    }

    public String getTitle() {
        return title;
    }

    public long getBannerID() {
        return bannerID;
    }

    public String getIsActive() {
        return isActive;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "campaignID=" + campaignID +
                ", bannerID=" + bannerID +
                ", title='" + title + '\'' +
                '}';
    }
}
