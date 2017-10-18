package com.phapps.elitedangerous.eddb.dto;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class DistancesSearchResultsDto {
    @SerializedName("id")
    private Long mId;
    @SerializedName("sys1")
    private SystemDto mSystem1;
    @SerializedName("sys2")
    private SystemDto mSystem2;
    @SerializedName("distance")
    private Double mDistance;
    @SerializedName("hidden_at")
    private Date mHiddenAt;

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public SystemDto getSystem1() {
        return mSystem1;
    }

    public void setSystem1(SystemDto system1) {
        mSystem1 = system1;
    }

    public SystemDto getSystem2() {
        return mSystem2;
    }

    public void setSystem2(SystemDto system2) {
        mSystem2 = system2;
    }

    public Double getDistance() {
        return mDistance;
    }

    public void setDistance(Double distance) {
        mDistance = distance;
    }

    public Date getHiddenAt() {
        return mHiddenAt;
    }

    public void setHiddenAt(Date hiddenAt) {
        mHiddenAt = hiddenAt;
    }

    @Override
    public String toString() {
        return "DistancesSearchResultsDto{" +
                "\nmId=" + mId + '\'' +
                ",\n mSystem1=" + mSystem1 + '\'' +
                ",\n mSystem2=" + mSystem2 + '\'' +
                ",\n mDistance=" + mDistance + '\'' +
                ",\n mHiddenAt=" + mHiddenAt + '\'' +
                '}';
    }
}
