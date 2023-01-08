package com.blog.commentmicroservice.Domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name = "comment")
public class Comment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;
    
    @Column(name = "post_id")
    private Long postId;

    @Column(name = "comment_body", columnDefinition = "TEXT")
    @Lob
    @NotEmpty(message = "** Please write something **")
    private String commentBody;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_date", nullable = false, updatable = false)
    @CreationTimestamp
    private Date commentDate;


    private Integer userId;
    private Boolean status;

    

    public Comment() {

    }

    

    public Comment(Long postId, String commentBody, Date commentDate, Integer userId,  Boolean status) {
        super();
        this.postId = postId;
        this.commentBody = commentBody;
        this.commentDate = commentDate;
        this.userId = userId;
        this.status = true;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    
}