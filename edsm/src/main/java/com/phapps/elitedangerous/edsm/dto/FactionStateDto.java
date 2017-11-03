package com.phapps.elitedangerous.edsm.dto;

import com.google.gson.annotations.SerializedName;

public class FactionStateDto {
    @SerializedName("state")
    private String mState;
    @SerializedName("trend")
    private Integer mTrend;

    public String getState() {
        return mState;
    }

    public void setState(String state) {
        mState = state;
    }

    public Integer getTrend() {
        return mTrend;
    }

    public void setTrend(Integer trend) {
        mTrend = trend;
    }

    @Override
    public String toString() {
        return "FactionStateDto{" +
                "\nmState='" + mState + '\'' +
                ",\n mTrend=" + mTrend + '\'' +
                '}';
    }
}
