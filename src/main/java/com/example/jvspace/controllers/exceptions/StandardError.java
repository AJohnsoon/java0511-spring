package com.example.jvspace.controllers.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class StandardError implements Serializable {

    private static final Long serialVersionUID = 1L;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    @Getter
    @Setter
    private Instant timestamp;

    @Getter
    @Setter
    private Integer status;

    @Getter
    @Setter
    private String message;

    @Getter
    @Setter
    private String tracer;

    @Getter
    @Setter
    private String path;

}
