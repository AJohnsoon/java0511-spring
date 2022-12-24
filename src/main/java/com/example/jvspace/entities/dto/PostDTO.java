package com.example.jvspace.entities.dto;

import com.example.jvspace.entities.Comment;
import com.example.jvspace.entities.Post;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PostDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private String id;
    private Date date;
    private String title;
    private String body;
    private AuthorDTO author;
    private List<String> comments = new ArrayList<>();

    public PostDTO(){}

    public PostDTO(Post postEntity){
        id = postEntity.getId();
        date = postEntity.getDate();
        title = postEntity.getTitle();
        body = postEntity.getBody();
        author = new AuthorDTO(postEntity.getUser());
        comments = postEntity.getComments().stream().map( Comment::getId ).collect( Collectors.toList());
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

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }
    public List<String> getComments() {
        return comments;
    }
    public void setComments(List<String> comments) {
        this.comments = comments;
    }
}
