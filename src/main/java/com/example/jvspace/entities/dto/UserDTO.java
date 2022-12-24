package com.example.jvspace.entities.dto;

import com.example.jvspace.entities.User;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String email;
    private String phone;
    private List<String> postIds = new ArrayList<>();

    private List<String> commentsIds = new ArrayList<>();
    public UserDTO() {}

    public UserDTO(User obj) {
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
        phone = obj.getPhone();
        postIds = obj.getPostIds();
        commentsIds = obj.getCommentsIds();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<String> getPostIds() {
        return postIds;
    }

    public void setPostIds(List<String> postIds) {
        this.postIds = postIds;
    }

    public List<String> getCommentsIds() {
        return commentsIds;
    }

    public void setCommentsIds(List<String> commentsIds) {
        this.commentsIds = commentsIds;
    }
}
