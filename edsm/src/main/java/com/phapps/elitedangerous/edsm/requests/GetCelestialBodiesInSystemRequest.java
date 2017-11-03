package com.phapps.elitedangerous.edsm.requests;

public class GetCelestialBodiesInSystemRequest {
    private String mSystemName;
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
