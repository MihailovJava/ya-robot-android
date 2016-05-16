package ru.yarobot.entities.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Status {
    @JsonProperty("data")
    private int code;

    public int getCode() {
        return code;
    }
}
