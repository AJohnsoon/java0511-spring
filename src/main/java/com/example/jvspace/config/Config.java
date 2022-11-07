package com.example.jvspace.config;

import com.example.jvspace.entities.User;
import com.example.jvspace.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.convert.*;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Configuration
@Profile("test")
public class Config{
    @Autowired
    private MongoDatabaseFactory mongoFactory;

    @Autowired
    MongoMappingContext mongoMappingContext;

    @Bean
    public MongoConverter mappingMongoConverter(){
        DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoFactory);
        MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, mongoMappingContext);
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
        return converter;
    }
}
