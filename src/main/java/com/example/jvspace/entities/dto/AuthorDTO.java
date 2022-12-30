package com.example.jvspace.entities.dto;

import com.example.jvspace.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
public class AuthorDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String name;

    public AuthorDTO(User user){
        if(user != null){
            this.id = user.getId();
            this.name = user.getName();
        }
    }

}
