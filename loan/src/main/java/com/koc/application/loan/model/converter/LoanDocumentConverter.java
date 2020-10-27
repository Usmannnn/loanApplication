package com.koc.application.loan.model.converter;

import com.koc.application.loan.model.dto.LoanDto;
import org.bson.Document;
import org.springframework.stereotype.Component;

@Component
public class LoanDocumentConverter {

    public LoanDto convert(Document document) {

        if (document == null) {
            return null;
        }

        LoanDto loanDto = new LoanDto();

        loanDto.setTcNo(document.get("tcNo").toString());
        loanDto.setFullName(document.get("fullName").toString());
        loanDto.setPhoneNumber(document.get("phoneNumber").toString());
        loanDto.setMonthlyIncome(document.getLong("income"));
        loanDto.setLoanScore(document.getLong("loanScore"));
        loanDto.setLimit(document.getLong("limit"));

        return loanDto;
    }
}
