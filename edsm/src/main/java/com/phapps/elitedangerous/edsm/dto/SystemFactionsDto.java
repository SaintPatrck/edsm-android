package com.phapps.elitedangerous.edsm.dto;

import com.google.gson.annotations.SerializedName;

public class SystemFactionsDto {
    @SerializedName("id")
    private Long mSystemId;
    @SerializedName("name")
    private String mSystemName;
    @SerializedName("controllingFaction")
    private FactionDto mControllingFaction;
    @SerializedName("factions")
    private FactionDto[] mFactions;

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

    public FactionDto getControllingFaction() {
        return mControllingFaction;
    }

    public void setControllingFaction(FactionDto controllingFaction) {
        mControllingFaction = controllingFaction;
    }

    public FactionDto[] getFactions() {
        return mFactions;
    }

    public void setFactions(FactionDto[] factions) {
        mFactions = factions;
    }
}
