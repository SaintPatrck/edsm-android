package com.phapps.elitedangerous.eddb.dto;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class CreditsDto {
    @SerializedName("balance")
    private Long mBalance;
    @SerializedName("loan")
    private Long mLoan;
    @SerializedName("date")
    private Date mDate;

    public Long getBalance() {
        return mBalance;
    }

    public void setBalance(Long balance) {
        mBalance = balance;
    }

    public Long getLoan() {
        return mLoan;
    }

    public void setLoan(Long loan) {
        mLoan = loan;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }
}
