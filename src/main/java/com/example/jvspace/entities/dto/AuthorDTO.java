package com.example.jvspace.entities.dto;

import com.example.jvspace.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter

public class AuthorDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    public AuthorDTO(User user){
        if(user != null){
            this.id = user.getId();
            this.name = user.getName();
        }
    }

}
