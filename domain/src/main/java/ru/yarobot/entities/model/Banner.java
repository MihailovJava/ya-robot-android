package ru.yarobot.entities.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import ru.yarobot.services.Transliterator;


public class Banner {
    private String id;
    @JsonProperty("BannerID")
    private long bannerId;
    @JsonProperty("CampaignID")
    private int campaignId;
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

    private BannerInfo bannerInfo;

    public List<Phrase> getPhrases() {
        return phrases;
    }

    public String getDomain() {
        return domain;
    }

    public String getTitle() {
        return title;
    }

    public long getBannerId() {
        return bannerId;
    }

    public String getIsActive() {
        return isActive;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "campaignId=" + campaignId +
                ", bannerId=" + bannerId +
                ", title='" + new Transliterator().transliterate(title) + '\'' +
                '}';
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public BannerInfo getBannerInfo() {
        return bannerInfo;
    }

    public void setBannerInfo(BannerInfo bannerInfo) {
        this.bannerInfo = bannerInfo;
    }
}
