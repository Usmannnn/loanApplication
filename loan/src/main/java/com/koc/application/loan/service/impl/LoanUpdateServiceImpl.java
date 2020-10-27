package com.koc.application.loan.service.impl;

import com.koc.application.loan.calculator.LoanCalculator;
import com.koc.application.loan.dao.LoanDao;
import com.koc.application.loan.model.converter.LoanDocumentConverter;
import com.koc.application.loan.model.converter.LoanDtoToDocumentConverter;
import com.koc.application.loan.model.dto.LoanDto;
import com.koc.application.loan.model.request.LoanResultRequest;
import com.koc.application.loan.model.response.LoanResultResponse;
import com.koc.application.loan.model.response.converter.LoanDtoToResponseConverter;
import com.koc.application.loan.service.LoanLoadingService;
import com.koc.application.loan.service.LoanUpdateService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanUpdateServiceImpl implements LoanUpdateService {

    private final LoanLoadingService loanLoadingService;
    private final LoanCalculator loanCalculator;
    private final LoanDao loanDao;
    private final LoanDtoToDocumentConverter loanDtoToDocumentConverter;
    private final LoanDtoToResponseConverter loanDtoToResponseConverter;
    private final LoanDocumentConverter loanDocumentConverter;

    @Autowired
    public LoanUpdateServiceImpl(LoanLoadingService loanLoadingService,
                                 LoanDao loanDao,
                                 LoanCalculator loanCalculator,
                                 LoanDtoToDocumentConverter loanDtoToDocumentConverter,
                                 LoanDtoToResponseConverter loanDtoToResponseConverter,
                                 LoanDocumentConverter loanDocumentConverter) {
        this.loanLoadingService = loanLoadingService;
        this.loanCalculator = loanCalculator;
        this.loanDao = loanDao;
        this.loanDtoToDocumentConverter = loanDtoToDocumentConverter;
        this.loanDtoToResponseConverter = loanDtoToResponseConverter;
        this.loanDocumentConverter = loanDocumentConverter;
    }

    @Override
    public LoanResultResponse updateCustomerLoanInfo(LoanResultRequest loanResultRequest) {
        if (loanResultRequest.getTcNo() == null){
            return null;
        }

        LoanDto loanDto = loanLoadingService.getCustomerLoanInfo(loanResultRequest.getTcNo());

        Long calculationResult = loanCalculator.calculate(loanDto.getLoanScore(), loanDto.getMonthlyIncome());

        Document document = loanDtoToDocumentConverter.convert(loanDto, calculationResult);

        loanDao.update(loanResultRequest.getTcNo(), document);

        LoanDto convertedLoanDto = loanDocumentConverter.convert(document);

        return loanDtoToResponseConverter.convert(convertedLoanDto);
    }
}
