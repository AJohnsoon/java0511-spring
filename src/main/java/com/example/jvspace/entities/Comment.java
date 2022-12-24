package com.example.jvspace.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Document(collection = "tb_comments")
public class Comment implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Date moment;
    private String comment;
    @DocumentReference(collection = "tb_user")
    private User author;

    @DocumentReference(collection = "tb_post")
    private Post postage;

    public Comment(){}

    public Comment(String id, Date moment, String comment, User author) {
        this.id = id;
        this.moment = moment;
        this.comment = comment;
        this.author = author;
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Post getPostage() {
        return postage;
    }

    public void setPostage(Post postage) {
        this.postage = postage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals( id, comment.id );
    }

    @Override
    public int hashCode() {
        return Objects.hash( id );
    }
}
