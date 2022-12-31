package com.example.jvspace.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "tb_post")
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Getter
@Setter
public class Post implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private Instant date = Instant.now();
    private String title;
    private String body;

    @DocumentReference(collection = "tb_user")
    private User user;

    @DocumentReference(collection = "tb_comments")
    private List<Comment> comments = new ArrayList<>();

}
