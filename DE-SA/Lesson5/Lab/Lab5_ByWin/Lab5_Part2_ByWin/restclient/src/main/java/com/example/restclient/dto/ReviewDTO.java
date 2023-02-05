package com.example.restclient.dto;

public class ReviewDTO {
    private String title;
    private String description;
    private int score;

    public ReviewDTO() {
    }

    public ReviewDTO(String title, String description, int score) {
        this.title = title;
        this.description = description;
        this.score = score;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
