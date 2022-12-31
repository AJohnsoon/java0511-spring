package com.example.jvspace.entities.dto;

import com.example.jvspace.entities.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class CommentDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private Instant moment;
    private String comment;
    private String author;
    private String postage;
    public CommentDTO(Comment commentEntity){
        id = commentEntity.getId();
        moment = commentEntity.getMoment();
        comment = commentEntity.getComment();
        author = commentEntity.getAuthor().getId();
        postage = commentEntity.getPostage().getId();
    }

}
