package com.phapps.elitedangerous.edsm.dto;

import com.google.gson.annotations.SerializedName;

public class StarDto {
    @SerializedName("type")
    private String mType;
    @SerializedName("name")
    private String mName;
    @SerializedName("isScoopable")
    private Boolean mScoopable;

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Boolean getScoopable() {
        return mScoopable;
    }

    public void setScoopable(Boolean scoopable) {
        mScoopable = scoopable;
    }

    @Override
    public String toString() {
        return "StarDto{" +
                "\nmType='" + mType + '\'' +
                ",\n mName='" + mName + '\'' +
                ",\n mScoopable=" + mScoopable + '\'' +
                '}';
    }
}
