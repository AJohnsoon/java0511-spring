package com.example.jvspace.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Document(collection = "tb_comments")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Comment implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private Instant moment = Instant.now();
    private String comment;

    @DocumentReference(collection = "tb_user")
    private User author;

    @DocumentReference(collection = "tb_post")
    private Post postage;

}
