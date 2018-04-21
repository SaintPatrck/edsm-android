/*
 * Copyright (c) 2017.
 *
 * Copyright 2017 Patrick Honkonen
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.phapps.elitedangerous.edsm.dto;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;
import com.phapps.elitedangerous.edsm.constants.enums.BodyType;
import com.phapps.elitedangerous.edsm.constants.enums.PlanetClass;
import com.phapps.elitedangerous.edsm.constants.enums.TerraformState;

import java.util.List;

public class BodyDto {
    @SerializedName("id")
    private Long mId;

    @SerializedName("name")
    private String mName;

    @SerializedName("type")
    private BodyType mType;

    @Nullable
    @SerializedName("subType")
    private PlanetClass mSubType;

    @SerializedName("distanceToArrival")
    private Double mDistanceToArrival;

    @SerializedName("isMainStar")
    private Boolean mMainStar;

    @SerializedName("isScoopable")
    private Boolean mScoopable;

    @SerializedName("age")
    private Integer mAge;

    @SerializedName("absoluteMagnitude")
    private Double mAbsoluteMagnitude;

    @SerializedName("solarMasses")
    private Double mSolarMasses;

    @SerializedName("solarRadius")
    private Double mSolarRadius;

    @SerializedName("surfaceTemperature")
    private Integer mSurfaceTemperature;

    @SerializedName("orbitalPeriod")
    private Double mOrbitalPeriod;

    @SerializedName("semiMajorAxis")
    private Double mSemiMajorAxis;

    @SerializedName("orbitalEccentricity")
    private Double mOrbitalEccentricity;

    @SerializedName("orbitalInclination")
    private Double mOrbitalInclination;

    @SerializedName("argOfPeriapsis")
    private Double mArgOfPeriapsis;

    @SerializedName("rotationalPeriod")
    private Double mRotationalPeriod;

    @SerializedName("rotationalPeriodTidallyLocked")
    private Boolean mRotationalPeriodTidallyLocked;

    @SerializedName("isLandable")
    private Boolean mLandable;

    @SerializedName("gravity")
    private Double mGravity;

    @SerializedName("earthMasses")
    private Double mEarthMasses;

    @SerializedName("radius")
    private Double mRadius;

    @SerializedName("volcanismType")
    private String mVolcanismType;

    @SerializedName("atmosphereType")
    private String mAtmosphereType;

    @SerializedName("terraformingState")
    private TerraformState mTerraformingState;

    @SerializedName("rings")
    private List<RingDto> mRings;

    public Long getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public BodyType getType() {
        return mType;
    }

    @Nullable
    public PlanetClass getPlanetClass() {
        return mSubType;
    }

    public Double getDistanceToArrival() {
        return mDistanceToArrival;
    }

    public Boolean getMainStar() {
        return mMainStar;
    }

    public Boolean getScoopable() {
        return mScoopable;
    }

    public Integer getAge() {
        return mAge;
    }

    public Double getAbsoluteMagnitude() {
        return mAbsoluteMagnitude;
    }

    public Double getSolarMasses() {
        return mSolarMasses;
    }

    public Double getSolarRadius() {
        return mSolarRadius;
    }

    public Integer getSurfaceTemperature() {
        return mSurfaceTemperature;
    }

    public Double getOrbitalPeriod() {
        return mOrbitalPeriod;
    }

    public Double getSemiMajorAxis() {
        return mSemiMajorAxis;
    }

    public Double getOrbitalEccentricity() {
        return mOrbitalEccentricity;
    }

    public Double getOrbitalInclination() {
        return mOrbitalInclination;
    }

    public Double getArgOfPeriapsis() {
        return mArgOfPeriapsis;
    }

    public Double getRotationalPeriod() {
        return mRotationalPeriod;
    }

    public Boolean getRotationalPeriodTidallyLocked() {
        return mRotationalPeriodTidallyLocked;
    }

    public Boolean getLandable() {
        return mLandable;
    }

    public Double getGravity() {
        return mGravity;
    }

    public Double getEarthMasses() {
        return mEarthMasses;
    }

    public Double getRadius() {
        return mRadius;
    }

    public String getVolcanismType() {
        return mVolcanismType;
    }

    public String getAtmosphereType() {
        return mAtmosphereType;
    }

    public TerraformState getTerraformState() {
        return mTerraformingState;
    }

    public List<RingDto> getRings() {
        return mRings;
    }

    @Override
    public String toString() {
        return "BodyDto{" +
                "\nmId=" + mId + '\'' +
                ",\n mName='" + mName + '\'' +
                ",\n mType='" + mType + '\'' +
                ",\n mSubType='" + mSubType + '\'' +
                ",\n mDistanceToArrival=" + mDistanceToArrival + '\'' +
                ",\n mMainStar=" + mMainStar + '\'' +
                ",\n mScoopable=" + mScoopable + '\'' +
                ",\n mAge=" + mAge + '\'' +
                ",\n mAbsoluteMagnitude=" + mAbsoluteMagnitude + '\'' +
                ",\n mSolarMasses=" + mSolarMasses + '\'' +
                ",\n mSolarRadius=" + mSolarRadius + '\'' +
                ",\n mSurfaceTemperature=" + mSurfaceTemperature + '\'' +
                ",\n mOrbitalPeriod=" + mOrbitalPeriod + '\'' +
                ",\n mSemiMajorAxis=" + mSemiMajorAxis + '\'' +
                ",\n mOrbitalEccentricity=" + mOrbitalEccentricity + '\'' +
                ",\n mOrbitalInclination=" + mOrbitalInclination + '\'' +
                ",\n mArgOfPeriapsis=" + mArgOfPeriapsis + '\'' +
                ",\n mRotationalPeriod=" + mRotationalPeriod + '\'' +
                ",\n mRotationalPeriodTidallyLocked=" + mRotationalPeriodTidallyLocked + '\'' +
                ",\n mLandable=" + mLandable + '\'' +
                ",\n mGravity=" + mGravity + '\'' +
                ",\n mEarthMasses=" + mEarthMasses + '\'' +
                ",\n mRadius=" + mRadius + '\'' +
                ",\n mVolcanismType='" + mVolcanismType + '\'' +
                ",\n mAtmosphereType='" + mAtmosphereType + '\'' +
                ",\n mTerraformingState='" + mTerraformingState + '\'' +
                ",\n mRings=" + mRings + '\'' +
                '}';
    }
}
