package com.phapps.elitedangerous.edsm.dto;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class DiscoveryDto {
    @SerializedName("commander")
    private String mCommanderName;

    @SerializedName("date")
    private Date mDiscoveryDate;

    public String getCommanderName() {
        return mCommanderName;
    }

    public Date getDiscoveryDate() {
        return mDiscoveryDate;
    }

    @Override
    public String toString() {
        return "DiscoveryDto{" +
                "\nmCommanderName='" + mCommanderName + '\'' +
                ",\n mDiscoveryDate=" + mDiscoveryDate + '\'' +
                '}';
    }
}
