package ru.yarobot.entities.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CampaignsParams {

    @JsonProperty("data")
    private List<CampaignParams> campaignParams;

    public List<CampaignParams> getCampaignParams() {
        return campaignParams;
    }
}