package ru.yarobot.entities.model;

import java.util.Date;

public class CampaignInfo {

    private String id;
    private int campaignId;
    private Status status;
    private String statusMessage;

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCampaignId() {
        return campaignId;
    }


    public String getStatusMessage() {
        return statusMessage;
    }
}
