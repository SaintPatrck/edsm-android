package com.phapps.elitedangerous.edsm.constants.enums;

import com.google.gson.annotations.SerializedName;

public enum TerraformState {

    @SerializedName("Terrformable")
    TERRFORMABLE,

    @SerializedName("Terraforming")
    TERRFORMING,

    @SerializedName("Terraformed")
    TERRAFORMED,

    @SerializedName("Not terraformed")
    NOT_TERRAFORMABLE

}
