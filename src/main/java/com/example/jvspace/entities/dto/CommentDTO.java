package com.example.jvspace.entities.dto;

import com.example.jvspace.entities.Comment;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public class CommentDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private String id;
    private Date moment;
    private String comment;
    private String author;
    private String postage;

    public CommentDTO(Comment commentEntity){
        id = commentEntity.getId();
        moment = commentEntity.getMoment();
        comment = commentEntity.getComment();
        author = commentEntity.getAuthor().getId();
        postage = commentEntity.getPostage().getId();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPostage() {
        return postage;
    }

    public void setPostage(String postage) {
        this.postage = postage;
    }
}
