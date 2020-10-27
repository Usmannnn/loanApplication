package com.koc.application.loan.model.response;

import java.util.Objects;

public class LoanResultResponse {

    private boolean loanResult;
    private Long loanLimit;

    public boolean isLoanResult() {
        return loanResult;
    }

    public void setLoanResult(boolean loanResult) {
        this.loanResult = loanResult;
    }

    public Long getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(Long loanLimit) {
        this.loanLimit = loanLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoanResultResponse that = (LoanResultResponse) o;
        return loanResult == that.loanResult &&
                Objects.equals(loanLimit, that.loanLimit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loanResult, loanLimit);
    }
}
