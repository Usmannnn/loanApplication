package com.koc.application.loan.configuration;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.logging.Logger;

@Configuration
public class LoanMongoDaoFactory {

    private static final Logger logger = Logger.getLogger("Logfile");

    private static final String MONGO_URI = "mongodb://admin:1234@cluster0-shard-00-00.yqbbo.mongodb.net:27017,cluster0-shard-00-01.yqbbo.mongodb.net:27017,cluster0-shard-00-02.yqbbo.mongodb.net:27017/koc?ssl=true&replicaSet=atlas-ba6n9v-shard-0&authSource=admin&retryWrites=true&w=majority";
    private static final String DATABASE_NAME = "koc";
    private static final String COLLECTION_NAME = "person";

    @Bean
    public MongoCollection<Document> getDocument() {
        try {
            MongoClientURI uri = new MongoClientURI(MONGO_URI);

            MongoClient mongoClient = new MongoClient(uri);
            MongoDatabase mongoDatabase = mongoClient.getDatabase(DATABASE_NAME);

            return mongoDatabase.getCollection(COLLECTION_NAME);
        } catch (Exception e) {
            logger.info("Date: " + new Date() + e.fillInStackTrace().toString());
        }
        return null;
    }
}
