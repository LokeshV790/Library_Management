package com.olik.library.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TestRepoImpl implements TestRepo {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public TestRepoImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void testMongoDBConnection() {
        // Test MongoDB connection
        if (mongoTemplate.getDb() != null) {
            System.out.println("Connected to MongoDB!");
        } else {
            System.out.println("Failed to connect to MongoDB!");
        }
    }
}
