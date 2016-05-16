package ru.yarobot.entities.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PhrasePrice {

    @JsonProperty("CampaignID")
    int campaignID;
    @JsonProperty("PhraseID")
    long phraseID;
    @JsonProperty("Price")
    float price;

    public void setCampaignID(int campaignID) {
        this.campaignID = campaignID;
    }

    public void setPhraseID(long phraseID) {
        this.phraseID = phraseID;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }
}
