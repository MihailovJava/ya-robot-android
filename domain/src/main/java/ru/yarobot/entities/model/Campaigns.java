package ru.yarobot.entities.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Campaigns {

    @JsonProperty("data")
    private List<Campaign> campaigns;

    public List<Campaign> getCampaigns() {
        return campaigns;
    }
}
