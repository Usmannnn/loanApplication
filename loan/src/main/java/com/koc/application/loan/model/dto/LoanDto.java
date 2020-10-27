package com.koc.application.loan.model.dto;

import com.koc.application.loan.model.request.LoanResultRequest;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class LoanDto {

    private static final long serialVersionUID = 5610553434825528639L;

    private String tcNo;
    private String fullName;
    private String phoneNumber;
    private Long monthlyIncome;
    private Long loanScore;
    private Long limit;

    public String getTcNo() {
        return tcNo;
    }

    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(Long monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public Long getLoanScore() {
        return loanScore;
    }

    public void setLoanScore(Long loanScore) {
        this.loanScore = loanScore;
    }

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }
}
