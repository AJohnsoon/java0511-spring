package com.example.jvspace.entities.dto;

import com.example.jvspace.entities.Comment;
import com.example.jvspace.entities.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public class PostDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    private String id;
    @Getter
    @Setter
    private Date date;
    @Getter
    @Setter
    private String title;
    @Getter
    @Setter
    private String body;
    @Getter
    @Setter
    private AuthorDTO author;
    @Getter
    @Setter
    private List<String> comments = new ArrayList<>();

    public PostDTO(Post postEntity){
        id = postEntity.getId();
        date = postEntity.getDate();
        title = postEntity.getTitle();
        body = postEntity.getBody();
        author = new AuthorDTO(postEntity.getUser());
        comments = postEntity.getComments().stream().map( Comment::getId ).collect( Collectors.toList());
    }

}
