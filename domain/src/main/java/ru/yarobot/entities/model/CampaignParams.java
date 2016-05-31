package ru.yarobot.entities.model;

import com.fasterxml.jackson.annotation.JsonProperty;



import java.util.Date;

public class CampaignParams {
    @JsonProperty("Login")
    private String login;
    @JsonProperty("CampaignID")
    private int campaignID;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("FIO")
    private String fio;

    @JsonProperty("StartDate")
    private String startDate;

    @JsonProperty("Sum")
    private float sum;
    @JsonProperty("Rest")
    private float rest;
    @JsonProperty("Shows")
    private int sows;
    @JsonProperty("Clicks")
    private int clicks;
    @JsonProperty("Strategy")
    private Strategy strategy;
    @JsonProperty("StatusBehavior")
    private String statusBehavior;
    @JsonProperty("Status")
    private String status;
    @JsonProperty("TimeZone")
    private String timeZone;
    @JsonProperty("StatusContextStop")
    private String statusContextStop;
    @JsonProperty("ContextLimit")
    private String contextLimit;
    @JsonProperty("ContextLimitSum")
    private int contextLimitSum;
    @JsonProperty("ContextPricePercent")
    private int contextPricePercent;
    @JsonProperty("AutoOptimization")
    private String autoOptimization;
    @JsonProperty("StatusMetricaControl")
    private String statusMetricaControl;
    @JsonProperty("DisabledDomains")
    private String disabledDomains;
    @JsonProperty("DisabledIps")
    private String disabledIps;
    @JsonProperty("StatusOpenStat")
    private String statusOpenStat;
    @JsonProperty("ConsiderTimeTarget")
    private String considerTimeTarget;
    @JsonProperty("ManagerName")
    private String managerName;
    @JsonProperty("AgencyName")
    private String agencyName;
    @JsonProperty("StatusShow")
    private String statusShow;
    @JsonProperty("StatusArchive")
    private String statusArchive;
    @JsonProperty("StatusActivating")
    private String statusActivating;
    @JsonProperty("StatusModerate")
    private String statusModerate;
    @JsonProperty("IsActive")
    private String isActive;
    @JsonProperty("AddRelevantPhrases")
    private String addRelevantPhrases;
    @JsonProperty("RelevantPhrasesBudgetLimit")
    private int relevantPhrasesBudgetLimit;
    @JsonProperty("SumAvailableForTransfer")
    private float sumAvailableForTransfer;

    public Strategy getStrategy() {
        return strategy;
    }
}

