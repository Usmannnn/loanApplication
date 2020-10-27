package com.koc.application.loan.model.response.converter;

import com.koc.application.loan.model.dto.LoanDto;
import com.koc.application.loan.model.response.LoanResultResponse;
import org.springframework.stereotype.Component;

@Component
public class LoanDtoToResponseConverter {

    public LoanResultResponse convert(LoanDto loanDto) {

        if (loanDto == null) {
            return null;
        }

        LoanResultResponse loanResultResponse = new LoanResultResponse();

        loanResultResponse.setLoanLimit(loanDto.getLimit());
        loanResultResponse.setLoanResult(loanDto.getLimit() != 0);

        return loanResultResponse;
    }
}
