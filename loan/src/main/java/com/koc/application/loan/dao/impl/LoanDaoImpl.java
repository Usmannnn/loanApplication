package com.koc.application.loan.dao.impl;

import com.koc.application.loan.configuration.LoanMongoDaoFactory;
import com.koc.application.loan.dao.LoanDao;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

@Repository
public class LoanDaoImpl implements LoanDao {

    private final LoanMongoDaoFactory loanMongoDaoFactory;

    public LoanDaoImpl(LoanMongoDaoFactory loanMongoDaoFactory) {
        this.loanMongoDaoFactory = loanMongoDaoFactory;
    }

    @Override
    public Document findWithTc(String tcNo) {

        MongoCollection<Document> document = this.loanMongoDaoFactory.getDocument();

        Bson filter = Filters.eq("tcNo", tcNo);

        FindIterable<Document> iterator = document.find(filter);
        MongoCursor<Document> mongoCursor = iterator.iterator();

        if (mongoCursor.hasNext()) {
            return mongoCursor.next();
        } else {
           return null;
        }
    }

    @Override
    public void update(Object tcNo, Document loanDocument) {
        MongoCollection<Document> document = this.loanMongoDaoFactory.getDocument();

        document.replaceOne(new Document("tcNo", tcNo), loanDocument);
    }
}
