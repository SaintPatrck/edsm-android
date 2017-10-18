package com.phapps.elitedangerous.eddb.dto;

import com.google.gson.annotations.SerializedName;

public class CreditSummaryDto {
    @SerializedName("msgnum")
    private Integer mMessageNumber;
    @SerializedName("msg")
    private String mMessage;
    @SerializedName("credits")
    private CreditsDto[] mCredits;

    public Integer getMessageNumber() {
        return mMessageNumber;
    }

    public void setMessageNumber(Integer messageNumber) {
        mMessageNumber = messageNumber;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public CreditsDto[] getCredits() {
        return mCredits;
    }

    public void setCredits(CreditsDto[] credits) {
        mCredits = credits;
    }
}
