package com.example.jvspace.entities.dto;

import com.example.jvspace.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String email;
    private String phone;
    private List<String> postIds = new ArrayList<>();
    private List<String> commentsIds = new ArrayList<>();
    public UserDTO(User obj) {
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
        phone = obj.getPhone();
        postIds = obj.getPostIds();
        commentsIds = obj.getCommentsIds();
    }

}
