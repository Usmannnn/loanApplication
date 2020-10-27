package com.koc.application.loan.calculator.impl;

import com.koc.application.loan.calculator.LoanCalculator;
import org.springframework.stereotype.Component;

@Component
public class LoanCalculatorImpl implements LoanCalculator {

    private static final int DEFAULT_LOAN_LIMIT = 10000;
    private static final int DEFAULT_LOAN_MULTIPLIER = 4;
    private static final int FIRST_LOAN_SCORE = 500;
    private static final int SECOND_LOAN_SCORE = 1000;
    private static final int MONTHLY_INCOME_VALUE = 5000;

    @Override
    public Long calculate(Long loanScore, Long monthlyIncome) {

        if (loanScore < FIRST_LOAN_SCORE) {
            return (long) 0;
        }
        else if (loanScore < SECOND_LOAN_SCORE && monthlyIncome < MONTHLY_INCOME_VALUE) {
            return (long) DEFAULT_LOAN_LIMIT;
        }
        else if (loanScore < SECOND_LOAN_SCORE && monthlyIncome > MONTHLY_INCOME_VALUE) {
            return (long) (DEFAULT_LOAN_LIMIT * DEFAULT_LOAN_MULTIPLIER / 2);
        }
        else {
            return monthlyIncome * DEFAULT_LOAN_MULTIPLIER;
        }
    }
}