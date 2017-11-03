package com.phapps.elitedangerous.edsm.dto;

import com.google.gson.annotations.SerializedName;

public class CommanderDto {
    @SerializedName("msgnum")
    private int mMessageNumber;
    @SerializedName("msg")
    private String mMessage;
    @SerializedName("ranks")
    private RanksDto mRanks;
    @SerializedName("progress")
    private ProgressDto mProgress;
    @SerializedName("ranksVerbose")
    private RanksVerboseDto mRanksVerbose;

    public int getMessageNumber() {
        return mMessageNumber;
    }

    public void setMessageNumber(int messageNumber) {
        mMessageNumber = messageNumber;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public RanksDto getRanks() {
        return mRanks;
    }

    public void setRanks(RanksDto ranks) {
        mRanks = ranks;
    }

    public ProgressDto getProgress() {
        return mProgress;
    }

    public void setProgress(ProgressDto progress) {
        mProgress = progress;
    }

    public RanksVerboseDto getRanksVerbose() {
        return mRanksVerbose;
    }

    public void setRanksVerbose(RanksVerboseDto ranksVerbose) {
        mRanksVerbose = ranksVerbose;
    }
}
