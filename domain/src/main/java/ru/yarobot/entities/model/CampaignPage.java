package ru.yarobot.entities.model;

import java.util.List;

public class CampaignPage {

    private final List<Campaign> campaigns;
    private final String next;
    private final Integer totalPages;

    public CampaignPage(List<Campaign> campaigns, String next, Integer totalPages) {
        this.campaigns = campaigns;
        this.next = next;
        this.totalPages = totalPages;
    }

    public List<Campaign> getCampaigns() {
        return campaigns;
    }

    public String getNext() {
        return next;
    }

    public Integer getTotalPages() {
        return totalPages;
    }
}