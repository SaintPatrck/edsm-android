package com.phapps.elitedangerous.edsm.requests;

import com.google.gson.annotations.SerializedName;

public class GetStationsInSystemRequest {
    @SerializedName("systemName")
    private String mSystemName;
    @SerializedName("id")
    private Long mSystemId;

    public String getSystemName() {
        return mSystemName;
    }

    public void setSystemName(String systemName) {
        mSystemName = systemName;
    }

    public Long getSystemId() {
        return mSystemId;
    }

    public void setSystemId(Long systemId) {
        mSystemId = systemId;
    }
}
