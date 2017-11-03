package com.phapps.elitedangerous.edsm.dto;

import com.google.gson.annotations.SerializedName;

public class RingDto {

    @SerializedName("name")
    private String mName;
    @SerializedName("type")
    private String mType;
    @SerializedName("mass")
    private Integer mMass;
    @SerializedName("innerRadius")
    private Integer mInnerRadius;
    @SerializedName("outerRadius")
    private Integer mOuterRadius;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public Integer getMass() {
        return mMass;
    }

    public void setMass(Integer mass) {
        mMass = mass;
    }

    public Integer getInnerRadius() {
        return mInnerRadius;
    }

    public void setInnerRadius(Integer innerRadius) {
        mInnerRadius = innerRadius;
    }

    public Integer getOuterRadius() {
        return mOuterRadius;
    }

    public void setOuterRadius(Integer outerRadius) {
        mOuterRadius = outerRadius;
    }

    @Override
    public String toString() {
        return "RingDto{" +
                "\nmName='" + mName + '\'' +
                ",\n mType='" + mType + '\'' +
                ",\n mMass=" + mMass + '\'' +
                ",\n mInnerRadius=" + mInnerRadius + '\'' +
                ",\n mOuterRadius=" + mOuterRadius + '\'' +
                '}';
    }
}
