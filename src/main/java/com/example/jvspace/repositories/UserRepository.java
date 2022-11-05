package com.example.jvspace.repositories;

import com.example.jvspace.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> { }
