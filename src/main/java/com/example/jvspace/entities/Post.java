package com.example.jvspace.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Document(collection = "tb_post")
public class Post implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Date date;
    private String title;
    private String body;

    @DocumentReference(collection = "tb_user")
    private User user;
    public Post() {
    }

    public Post(String id, Date date, String title, String body, User user) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id.equals( post.id );
    }

    @Override
    public int hashCode() {
        return Objects.hash( id );
    }
}
