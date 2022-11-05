package com.example.jvspace.config;

import com.example.jvspace.entities.User;
import com.example.jvspace.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class Config implements CommandLineRunner{
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User("1", "Maria Brown", "mariabrown@gmail.com", "988888888");
        User user2 = new User("2", "Bob Blue", "boblue@gmail.com", "9123456789");
        User user3 = new User("3", "Alex Green", "alexgreen@gmail.com", "944446666");

        userRepository.saveAll(Arrays.asList(user1, user2, user3));

    }
}
