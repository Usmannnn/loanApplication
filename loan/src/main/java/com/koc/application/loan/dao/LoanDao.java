package com.koc.application.loan.dao;

import org.bson.Document;

public interface LoanDao {

    Document findWithTc(String tcNo);

    void update(Object tcNo, Document loanDocument);
}
