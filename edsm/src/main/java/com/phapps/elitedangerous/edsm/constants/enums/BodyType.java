package com.phapps.elitedangerous.edsm.constants.enums;

import com.google.gson.annotations.SerializedName;

public enum BodyType {

    @SerializedName("Star")
    STAR,

    @SerializedName("Planet")
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
