package com.koc.application.loan.service.impl;

import com.koc.application.loan.dao.LoanDao;
import com.koc.application.loan.model.converter.LoanDocumentConverter;
import com.koc.application.loan.model.dto.LoanDto;
import com.koc.application.loan.service.LoanLoadingService;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class LoanLoadingServiceImpl implements LoanLoadingService {
    private final LoanDao loanDao;
    private final LoanDocumentConverter loanDocumentConverter;

    public LoanLoadingServiceImpl(LoanDao loanDao, LoanDocumentConverter loanDocumentConverter) {
        this.loanDao = loanDao;
        this.loanDocumentConverter = loanDocumentConverter;
    }

    @Override
    public LoanDto getCustomerLoanInfo(String tcNo) {

        Document document = loanDao.findWithTc(tcNo);

        return loanDocumentConverter.convert(document);
    }
}