package edu.mum.cs544.Domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    private String category;
    @NotBlank
    private String title;
    @Lob
    @NotBlank
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
        this.status = true; //as new post's status is default true.
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
    public LocalDateTime getPostedOn() {
        return postedOn;
    }
    public void setPostedOn(LocalDateTime postedOn) {
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
