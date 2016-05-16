package ru.yarobot.entities.model;

public class Snippet {
    private String domain;
    private String title;
    private Position position;

    public Snippet(String domain, String title, Position position) {
        this.domain = domain;
        this.title = title;
        this.position = position;
    }

    public String getDomain() {
        return domain;
    }

    public Position getPosition() {
        return position;
    }

    public String getTitle() {
        return title;
    }
}
