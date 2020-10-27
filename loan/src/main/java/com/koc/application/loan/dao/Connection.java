package com.koc.application.loan.dao;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class Connection {

    public Connection() {
        try {


            MongoClientURI uri = new MongoClientURI(
                    "mongodb://admin:1234@cluster0-shard-00-00.yqbbo.mongodb.net:27017,cluster0-shard-00-01.yqbbo.mongodb.net:27017,cluster0-shard-00-02.yqbbo.mongodb.net:27017/koc?ssl=true&replicaSet=atlas-ba6n9v-shard-0&authSource=admin&retryWrites=true&w=majority");

            MongoClient mongoClient = new MongoClient(uri);
            MongoDatabase database = mongoClient.getDatabase("test");


            System.out.println("okasokfaf");

        } catch (Exception e) {
            System.out.println("Bok");

        }
    }
}
