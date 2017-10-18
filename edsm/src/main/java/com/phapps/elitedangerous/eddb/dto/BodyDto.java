package com.phapps.elitedangerous.eddb.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BodyDto {
    @SerializedName("id")
    private Long mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("type")
    private String mType;
    @SerializedName("subType")
    private String mSubType;
    @SerializedName("distanceToArrival")
    private Long mDistanceToArrival;
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
    private String mTerraformingState;
    @SerializedName("rings")
    private List<RingDto> mRings;

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getSubType() {
        return mSubType;
    }

    public void setSubType(String subType) {
        mSubType = subType;
    }

    public Long getDistanceToArrival() {
        return mDistanceToArrival;
    }

    public void setDistanceToArrival(Long distanceToArrival) {
        mDistanceToArrival = distanceToArrival;
    }

    public Boolean getMainStar() {
        return mMainStar;
    }

    public void setMainStar(Boolean mainStar) {
        mMainStar = mainStar;
    }

    public Boolean getScoopable() {
        return mScoopable;
    }

    public void setScoopable(Boolean scoopable) {
        mScoopable = scoopable;
    }

    public Integer getAge() {
        return mAge;
    }

    public void setAge(Integer age) {
        mAge = age;
    }

    public Double getAbsoluteMagnitude() {
        return mAbsoluteMagnitude;
    }

    public void setAbsoluteMagnitude(Double absoluteMagnitude) {
        mAbsoluteMagnitude = absoluteMagnitude;
    }

    public Double getSolarMasses() {
        return mSolarMasses;
    }

    public void setSolarMasses(Double solarMasses) {
        mSolarMasses = solarMasses;
    }

    public Double getSolarRadius() {
        return mSolarRadius;
    }

    public void setSolarRadius(Double solarRadius) {
        mSolarRadius = solarRadius;
    }

    public Integer getSurfaceTemperature() {
        return mSurfaceTemperature;
    }

    public void setSurfaceTemperature(Integer surfaceTemperature) {
        mSurfaceTemperature = surfaceTemperature;
    }

    public Double getOrbitalPeriod() {
        return mOrbitalPeriod;
    }

    public void setOrbitalPeriod(Double orbitalPeriod) {
        mOrbitalPeriod = orbitalPeriod;
    }

    public Double getSemiMajorAxis() {
        return mSemiMajorAxis;
    }

    public void setSemiMajorAxis(Double semiMajorAxis) {
        mSemiMajorAxis = semiMajorAxis;
    }

    public Double getOrbitalEccentricity() {
        return mOrbitalEccentricity;
    }

    public void setOrbitalEccentricity(Double orbitalEccentricity) {
        mOrbitalEccentricity = orbitalEccentricity;
    }

    public Double getOrbitalInclination() {
        return mOrbitalInclination;
    }

    public void setOrbitalInclination(Double orbitalInclination) {
        mOrbitalInclination = orbitalInclination;
    }

    public Double getArgOfPeriapsis() {
        return mArgOfPeriapsis;
    }

    public void setArgOfPeriapsis(Double argOfPeriapsis) {
        mArgOfPeriapsis = argOfPeriapsis;
    }

    public Double getRotationalPeriod() {
        return mRotationalPeriod;
    }

    public void setRotationalPeriod(Double rotationalPeriod) {
        mRotationalPeriod = rotationalPeriod;
    }

    public Boolean getRotationalPeriodTidallyLocked() {
        return mRotationalPeriodTidallyLocked;
    }

    public void setRotationalPeriodTidallyLocked(Boolean rotationalPeriodTidallyLocked) {
        mRotationalPeriodTidallyLocked = rotationalPeriodTidallyLocked;
    }

    public Boolean getLandable() {
        return mLandable;
    }

    public void setLandable(Boolean landable) {
        mLandable = landable;
    }

    public Double getGravity() {
        return mGravity;
    }

    public void setGravity(Double gravity) {
        mGravity = gravity;
    }

    public Double getEarthMasses() {
        return mEarthMasses;
    }

    public void setEarthMasses(Double earthMasses) {
        mEarthMasses = earthMasses;
    }

    public Double getRadius() {
        return mRadius;
    }

    public void setRadius(Double radius) {
        mRadius = radius;
    }

    public String getVolcanismType() {
        return mVolcanismType;
    }

    public void setVolcanismType(String volcanismType) {
        mVolcanismType = volcanismType;
    }

    public String getAtmosphereType() {
        return mAtmosphereType;
    }

    public void setAtmosphereType(String atmosphereType) {
        mAtmosphereType = atmosphereType;
    }

    public String getTerraformingState() {
        return mTerraformingState;
    }

    public void setTerraformingState(String terraformingState) {
        mTerraformingState = terraformingState;
    }

    public List<RingDto> getRings() {
        return mRings;
    }

    public void setRings(List<RingDto> rings) {
        mRings = rings;
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
