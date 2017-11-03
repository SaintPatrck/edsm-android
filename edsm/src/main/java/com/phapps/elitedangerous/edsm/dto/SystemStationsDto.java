package com.phapps.elitedangerous.edsm.dto;

import com.google.gson.annotations.SerializedName;

public class SystemStationsDto {
    @SerializedName("id")
    private Long mSystemId;
    @SerializedName("name")
    private String mSystemName;
    @SerializedName("stations")
    private StationDto[] mStations;

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

    public StationDto[] getStations() {
        return mStations;
    }

    public void setStations(StationDto[] stations) {
        mStations = stations;
    }
}
