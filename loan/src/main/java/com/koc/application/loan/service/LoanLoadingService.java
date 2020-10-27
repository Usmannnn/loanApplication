package com.koc.application.loan.service;

import com.koc.application.loan.model.dto.LoanDto;

public interface LoanLoadingService {

    LoanDto getCustomerLoanInfo(String tcNo);
}
