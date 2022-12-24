package com.example.jvspace.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "tb_user")
public class User implements Serializable{
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String name;
    private String email;
    private String phone;

    private List<String> postIds = new ArrayList<>();

    private List<String> commentsIds = new ArrayList<>();

    public User(){}

    public User(String id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
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


    public List<String> getCommentsIds() {
        return commentsIds;
    }

    public void setCommentsIds(List<String> commentsIds) {
        this.commentsIds = commentsIds;
    }

    public void setPostIds(List<String> postIds) {
        this.postIds = postIds;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
