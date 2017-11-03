package com.phapps.elitedangerous.edsm.dto;

import com.google.gson.annotations.SerializedName;

public class SystemBodiesDto {
    @SerializedName("id")
    private Long mSystemId;
    @SerializedName("name")
    private String mSystemName;
    @SerializedName("bodies")
    private BodyDto[] mBodies;

    public Long getSystemId() {
        return mSystemId;
    }

    public void setSystemId(Long systemId) {
        mSystemId = systemId;
    }

    public String getSystemName() {
        return mSystemName;
    }

    public void setSystemName(String systemName) {
        mSystemName = systemName;
    }

    public BodyDto[] getBodies() {
        return mBodies;
    }

    public void setBodies(BodyDto[] bodies) {
        mBodies = bodies;
    }
}
