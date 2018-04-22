package com.phapps.elitedangerous.edsm.constants.enums;

import com.google.gson.annotations.SerializedName;

public enum BodySubType {
    // Stars
    @SerializedName("B (Blue-White) Star")
    B_BLUE_WHITE_STAR,

    @SerializedName("G (White-Yellow) Star")
    G_WHITE_YELLOW_STAR,

    @SerializedName("L (Brown dwarf) Star")
    L_BROWN_DWARF_STAR,

    @SerializedName("M (Red dwarf) Star")
    M_RED_DWARF_STAR,

    // Planets

    @SerializedName("Metal-rich body")
    METAL_RICH_BODY,

    @SerializedName("High metal content world")
    HIGH_METAL_CONTENT_BODY,

    @SerializedName("Rocky body")
    ROCKY_BODY,

    @SerializedName("Icy body")
    ICY_BODY,

    @SerializedName("Rocky Ice world")
    ROCKY_ICE_BODY,

    @SerializedName("Earth-like world")
    EARTHLIKE_BODY,

    @SerializedName("Water world")
    WATER_WORLD,

    @SerializedName("Ammonia world")
    AMMONIA_WORLD,

    @SerializedName("Water giant")
    WATER_GIANT,

    @SerializedName("Water giant with life")
    WATER_GIANT_WITH_LIFE,

    @SerializedName("Gas giant with water based life")
    GAS_GIANT_WITH_WATER_BASED_LIFE,

    @SerializedName("Gas giant with ammonia based life")
    GAS_GIANT_WITH_AMMONIA_BASED_LIFE,

    @SerializedName("Class I gas giant")
    CLASS_I_GAS_GIANT,

    @SerializedName("Class II gas giant")
    CLASS_II_GAS_GIANT,

    @SerializedName("Class III gas giant")
    SUDARSKY_CLASS_III_GAS_GIANT,

    @SerializedName("Class IV gas giant")
    SUDARSKY_CLASS_IV_GAS_GIANT,

    @SerializedName("Class V gas giant")
    SUDARSKY_CLASS_V_GAS_GIANT,

    @SerializedName("Helium-rich gas giant")
    HELIUM_RICH_GAS_GIANT,

    @SerializedName("Helium gas giant")
    HELIUM_GAS_GIANT,
}
