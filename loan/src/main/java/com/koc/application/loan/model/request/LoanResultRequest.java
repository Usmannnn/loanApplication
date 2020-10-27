package com.koc.application.loan.model.request;

import java.io.Serializable;
import java.util.Objects;


public class LoanResultRequest implements Serializable {

    private static final long serialVersionUID = 5610553434825528639L;

    private String tcNo;
    private String fullName;
    private String phoneNumber;
    private String monthlyIncome;


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

    public String getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(String monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoanResultRequest that = (LoanResultRequest) o;
        return Objects.equals(tcNo, that.tcNo) &&
                Objects.equals(fullName, that.fullName) &&
                Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(monthlyIncome, that.monthlyIncome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tcNo, fullName, phoneNumber, monthlyIncome);
    }

    @Override
    public String toString() {
        return "LoanResultRequest{" +
                "tcNo='" + tcNo + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", monthlyIncome='" + monthlyIncome + '\'' +
                '}';
    }
}
