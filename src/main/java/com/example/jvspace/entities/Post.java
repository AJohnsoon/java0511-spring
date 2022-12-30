package com.example.jvspace.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(collection = "tb_post")
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class Post implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Getter
    @Setter
    private String id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    @Getter
    @Setter
    private Date date;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private String body;

    @DocumentReference(collection = "tb_user")
    @Getter
    @Setter
    private User user;

    @DocumentReference(collection = "tb_comments")
    @Getter
    @Setter
    private List<Comment> comments = new ArrayList<>();

}
