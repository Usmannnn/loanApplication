package com.koc.application.loan.controller;

import com.koc.application.loan.model.request.LoanResultRequest;
import com.koc.application.loan.model.response.LoanResultResponse;
import com.koc.application.loan.service.LoanUpdateService;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoanUpdateController {

    LoanUpdateService loanUpdateService;

    public LoanUpdateController(LoanUpdateService loanUpdateService) {
        this.loanUpdateService = loanUpdateService;
    }

    @RequestMapping(value="/loan", method = RequestMethod.PUT)
    @CrossOrigin
    public LoanResultResponse updateCustomerLoanInfo(@RequestBody LoanResultRequest loanResultRequest) {
        return loanUpdateService.updateCustomerLoanInfo(loanResultRequest);
    }
}
