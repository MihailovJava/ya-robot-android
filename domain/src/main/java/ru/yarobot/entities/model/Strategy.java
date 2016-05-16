package ru.yarobot.entities.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Strategy {

    @JsonProperty("StrategyName")
    private String strategyName;
    @JsonProperty("MaxPrice")
    private float maxPrice;
    @JsonProperty("AveragePrice")
    private float averagePrice;
    @JsonProperty("WeeklySumLimit")
    private float weeklySumLimit;
    @JsonProperty("ClicksPerWeek")
    private int clicksPerWeek;

    public String getStrategyName() {
        return strategyName;
    }
}
