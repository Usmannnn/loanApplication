package com.koc.application.loan.service;

import com.koc.application.loan.model.request.LoanResultRequest;
import com.koc.application.loan.model.response.LoanResultResponse;

public interface LoanUpdateService {

    LoanResultResponse updateCustomerLoanInfo(LoanResultRequest loanResultRequest);


}
