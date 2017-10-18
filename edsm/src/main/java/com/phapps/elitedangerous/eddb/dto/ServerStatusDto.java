package com.phapps.elitedangerous.eddb.dto;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class ServerStatusDto {

    @SerializedName("lastUpdate")
    private Date mLastUpdate;
    @SerializedName("type")
    private String mType;
    @SerializedName("message")
    private String mMessage;
    @SerializedName("status")
    private Integer mStatus;

    public Date getLastUpdate() {
        return mLastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        mLastUpdate = lastUpdate;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public Integer getStatus() {
        return mStatus;
    }

    public void setStatus(Integer status) {
        mStatus = status;
    }
}
