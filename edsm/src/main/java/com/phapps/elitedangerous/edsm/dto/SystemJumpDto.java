package com.phapps.elitedangerous.edsm.dto;

import com.google.gson.annotations.SerializedName;

public class SystemJumpDto {
    @SerializedName("name")
    private String mName;
    @SerializedName("coordinates")
    private double[] mCoordinates;
}
