package com.koc.application.loan.calculator;

public interface LoanCalculator {

    Long calculate(Long loanScore, Long monthlyIncome);
}
