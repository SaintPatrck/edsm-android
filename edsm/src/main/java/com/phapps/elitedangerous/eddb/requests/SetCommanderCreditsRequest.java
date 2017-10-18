package com.phapps.elitedangerous.eddb.requests;

public class SetCommanderCreditsRequest extends BaseCommanderRequest {
    private Long mBalance;
    private Long mLoan;

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
}
