package com.phapps.elitedangerous.eddb.dto;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class SystemDto {
    @SerializedName("id")
    private Long mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("coords")
    private CoordinatesDto mCoordinates;
    @SerializedName("duplicates")
    private Long mDuplicates;
    @SerializedName("requirePermit")
    private Boolean mRequirePermit;
    @SerializedName("permitName")
    private String mPermitName;
    @SerializedName("information")
    private InformationDto mInformation;
    @SerializedName("primaryStar")
    private StarDto mStar;
    @SerializedName("hidden_at")
    private Date mHiddenAt;
    @SerializedName("mergedTo")
    private Long mMergedTo;

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

    public CoordinatesDto getCoordinates() {
        return mCoordinates;
    }

    public void setCoordinates(CoordinatesDto coordinates) {
        mCoordinates = coordinates;
    }

    public Long getDuplicates() {
        return mDuplicates;
    }

    public void setDuplicates(Long duplicates) {
        mDuplicates = duplicates;
    }

    public Boolean getRequirePermit() {
        return mRequirePermit;
    }

    public void setRequirePermit(Boolean requirePermit) {
        mRequirePermit = requirePermit;
    }

    public String getPermitName() {
        return mPermitName;
    }

    public void setPermitName(String permitName) {
        mPermitName = permitName;
    }

    public InformationDto getInformation() {
        return mInformation;
    }

    public void setInformation(InformationDto information) {
        mInformation = information;
    }

    public StarDto getStar() {
        return mStar;
    }

    public void setStar(StarDto star) {
        mStar = star;
    }

    public Date getHiddenAt() {
        return mHiddenAt;
    }

    public void setHiddenAt(Date hiddenAt) {
        mHiddenAt = hiddenAt;
    }

    public Long getMergedTo() {
        return mMergedTo;
    }

    public void setMergedTo(Long mergedTo) {
        mMergedTo = mergedTo;
    }

    @Override
    public String toString() {
        return "SystemDto{" +
                "\nmId=" + mId + '\'' +
                ",\n mName='" + mName + '\'' +
                ",\n mCoordinates=" + mCoordinates + '\'' +
                ",\n mDuplicates=" + mDuplicates + '\'' +
                ",\n mRequirePermit=" + mRequirePermit + '\'' +
                ",\n mPermitName='" + mPermitName + '\'' +
                ",\n mInformation=" + mInformation + '\'' +
                ",\n mStar=" + mStar + '\'' +
                ",\n mHiddenAt=" + mHiddenAt + '\'' +
                ",\n mMergedTo=" + mMergedTo + '\'' +
                '}';
    }
}
