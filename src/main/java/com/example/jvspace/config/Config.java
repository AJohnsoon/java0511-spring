package com.example.jvspace.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.convert.*;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

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
