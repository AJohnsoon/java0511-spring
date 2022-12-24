package com.example.jvspace.repositories;

import com.example.jvspace.entities.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, String> {
}
