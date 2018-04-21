package com.phapps.elitedangerous.edsm.constants.enums;

import com.google.gson.annotations.SerializedName;

public enum BodyType {

    @SerializedName("STAR")
    STAR,

    @SerializedName("PLANET")
    PLANET,

    @SerializedName("PlanetaryRing")
    PLANETARY_RING,

    @SerializedName("StellarRing")
    STELLAR_RING,

    @SerializedName("Station")
    STATION,

    @SerializedName("AsteroidCluster")
    ASTROID_CLUSTER

}
