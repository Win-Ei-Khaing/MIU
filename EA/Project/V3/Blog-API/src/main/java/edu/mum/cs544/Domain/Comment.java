package edu.mum.cs544.Domain;

import java.util.Date;


public class Comment {
    
    private Long id;
    private Long postId;
    private String commentBody;
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