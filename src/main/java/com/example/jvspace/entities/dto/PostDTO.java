package com.example.jvspace.entities.dto;

import com.example.jvspace.entities.Comment;
import com.example.jvspace.entities.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Setter
public class PostDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private Instant date;
    private String title;
    private String body;
    private AuthorDTO author;
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
