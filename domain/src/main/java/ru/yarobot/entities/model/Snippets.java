package ru.yarobot.entities.model;

import java.util.List;

public class Snippets {
    private List<Snippet> snippets;

    public Snippets(List<Snippet> snippets) {
        this.snippets = snippets;
    }

    public List<Snippet> getSnippets() {
        return snippets;
    }

}
