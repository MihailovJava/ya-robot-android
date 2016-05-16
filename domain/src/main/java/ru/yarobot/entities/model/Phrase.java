package ru.yarobot.entities.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Phrase {
    @JsonProperty("BannerID")
    private long bannerID;
    @JsonProperty("CampaignID")
    private int campaignID;
    @JsonProperty("PhraseID")
    private long phraseID;
    @JsonProperty("Phrase")
    private String phrase;
    @JsonProperty("IsRubric")
    private String isRubric;
    @JsonProperty("Price")
    private float price;
    @JsonProperty("ContextPrice")
    private float contextPrice;
    @JsonProperty("AutoBroker")
    private String autoBroker;
    @JsonProperty("StatusPhraseModerate")
    private String statusPhraseModerate;
    @JsonProperty("AutoBudgetPriority")
    private String autoBudgetPriority;
    @JsonProperty("Clicks")
    private int clicks;
    @JsonProperty("Shows")
    private int shows;
    @JsonProperty("Min")
    private float min;
    @JsonProperty("Max")
    private float max;
    @JsonProperty("PremiumMin")
    private float premiumMin;
    @JsonProperty("PremiumMax")
    private float premiumMax;
    @JsonProperty("LowCTRWarning")
    private String lowCTRWarning;
    @JsonProperty("LowCTR")
    private String lowCTR;
    @JsonProperty("ContextLowCTR")
    private String contextLowCTR;
    @JsonProperty("CurrentOnSearch")
    private float currentOnSearch;
    @JsonProperty("MinPrice")
    private float minPrice;
    @JsonProperty("Prices")
    private List<Float> prices;

    public long getPhraseID() {
        return phraseID;
    }

    public float getPrice() {
        return price;
    }

    public String getPhrase() {
        return phrase;
    }

    public List<Float> getPrices() {
        return prices;
    }
}
