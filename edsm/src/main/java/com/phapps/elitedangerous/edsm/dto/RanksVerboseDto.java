package com.phapps.elitedangerous.edsm.dto;

import com.google.gson.annotations.SerializedName;

public class RanksVerboseDto {
    @SerializedName("Combat")
    private String mCombat;
    @SerializedName("Trade")
    private String mTrade;
    @SerializedName("Explore")
    private String mExplore;
    @SerializedName("CQC")
    private String mCqc;
    @SerializedName("Federation")
    private String mFederation;
    @SerializedName("Empire")
    private String mEmpire;

    public String getCombat() {
        return mCombat;
    }

    public void setCombat(String combat) {
        mCombat = combat;
    }

    public String getTrade() {
        return mTrade;
    }

    public void setTrade(String trade) {
        mTrade = trade;
    }

    public String getExplore() {
        return mExplore;
    }

    public void setExplore(String explore) {
        mExplore = explore;
    }

    public String getCqc() {
        return mCqc;
    }

    public void setCqc(String cqc) {
        mCqc = cqc;
    }

    public String getFederation() {
        return mFederation;
    }

    public void setFederation(String federation) {
        mFederation = federation;
    }

    public String getEmpire() {
        return mEmpire;
    }

    public void setEmpire(String empire) {
        mEmpire = empire;
    }
}
