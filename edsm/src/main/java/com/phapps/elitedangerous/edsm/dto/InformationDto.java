package com.phapps.elitedangerous.edsm.dto;

import com.google.gson.annotations.SerializedName;

public class InformationDto {
    @SerializedName("eddbId")
    private Long mDatabaseId;
    @SerializedName("allegiance")
    private String mAllegiance;
    @SerializedName("government")
    private String mGovernment;
    @SerializedName("faction")
    private String mFaction;
    @SerializedName("state")
    private String mState;
    @SerializedName("population")
    private Long mPopulation;
    @SerializedName("security")
    private String mSecurity;
    @SerializedName("economy")
    private String mEconomy;
    @SerializedName("reserve")
    private String mReserve;

    public Long getDatabaseId() {
        return mDatabaseId;
    }

    public void setDatabaseId(Long databaseId) {
        mDatabaseId = databaseId;
    }

    public String getAllegiance() {
        return mAllegiance;
    }

    public void setAllegiance(String allegiance) {
        mAllegiance = allegiance;
    }

    public String getGovernment() {
        return mGovernment;
    }

    public void setGovernment(String government) {
        mGovernment = government;
    }

    public String getFaction() {
        return mFaction;
    }

    public void setFaction(String faction) {
        mFaction = faction;
    }

    public String getState() {
        return mState;
    }

    public void setState(String state) {
        mState = state;
    }

    public Long getPopulation() {
        return mPopulation;
    }

    public void setPopulation(Long population) {
        mPopulation = population;
    }

    public String getSecurity() {
        return mSecurity;
    }

    public void setSecurity(String security) {
        mSecurity = security;
    }

    public String getEconomy() {
        return mEconomy;
    }

    public void setEconomy(String economy) {
        mEconomy = economy;
    }

    public String getReserve() {
        return mReserve;
    }

    public void setReserve(String reserve) {
        mReserve = reserve;
    }

    @Override
    public String toString() {
        return "InformationDto{" +
                "\nmDatabaseId=" + mDatabaseId + '\'' +
                ",\n mAllegiance='" + mAllegiance + '\'' +
                ",\n mGovernment='" + mGovernment + '\'' +
                ",\n mFaction='" + mFaction + '\'' +
                ",\n mState='" + mState + '\'' +
                ",\n mPopulation=" + mPopulation + '\'' +
                ",\n mSecurity='" + mSecurity + '\'' +
                ",\n mEconomy='" + mEconomy + '\'' +
                ",\n mReserve='" + mReserve + '\'' +
                '}';
    }
}
