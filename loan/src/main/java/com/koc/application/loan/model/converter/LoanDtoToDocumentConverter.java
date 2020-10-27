package com.koc.application.loan.model.converter;

import com.koc.application.loan.model.dto.LoanDto;
import org.bson.Document;
import org.springframework.stereotype.Component;

@Component
public class LoanDtoToDocumentConverter {

    public Document convert(LoanDto loanDto, Long calculationResult) {

        if (loanDto == null) {
            return null;
        }

        Document document = new Document();

        document.put("tcNo", loanDto.getTcNo());
        document.put("fullName", loanDto.getFullName());
        document.put("phoneNumber", loanDto.getPhoneNumber());
        document.put("income", loanDto.getMonthlyIncome());
        document.put("loanScore", loanDto.getLoanScore());
        document.put("limit", calculationResult);

        return document;
    }
}
