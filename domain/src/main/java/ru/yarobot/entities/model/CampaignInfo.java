package ru.yarobot.entities.model;

import java.util.Date;

public class CampaignInfo {

    private String id;
    private int campaignId;
    private Date date = new Date();
    private Status status;
    private String statusMessage;

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
}
