package com.phapps.elitedangerous.edsm.dto;

import com.google.gson.annotations.SerializedName;

public class SetShipIdResultDto {
    @SerializedName("msgnum")
    private Integer mMessageNumber;
    @SerializedName("msg")
    private String mMessage;
    @SerializedName("inDatabase")
    private Boolean mInDatabase;

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

    /**
     * States if the current {@code shipId} is in the EDSM database already or if you need to add the ship.
     *
     * @return true if the ship is in the database already, false otherwise.
     */
    public Boolean getInDatabase() {
        return mInDatabase;
    }

    public void setInDatabase(Boolean inDatabase) {
        mInDatabase = inDatabase;
    }
}
