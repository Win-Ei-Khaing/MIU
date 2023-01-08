package edu.mum.cs544.Domain;

import java.time.LocalDateTime;

public class Post {
    private Long id;
    private String category;
    private String title;
    private String description;
    private LocalDateTime postedOn;
    private Integer postedBy;
    private Boolean status;

    public Post() {
    }
    public Post(Long id, String category, String title, String description, LocalDateTime postedOn, Integer postedBy) {
        this.id = id;
        this.category = category;
        this.title = title;
        this.description = description;
        this.postedOn = postedOn;
        this.postedBy = postedBy;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
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
    public LocalDateTime getpostedOn() {
        return postedOn;
    }
    public void setpostedOn(LocalDateTime postedOn) {
        this.postedOn = postedOn;
    }
    public Integer getPostedBy() {
        return postedBy;
    }
    public void setPostedBy(Integer postedBy) {
        this.postedBy = postedBy;
    }
    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
}
