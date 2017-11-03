package com.phapps.elitedangerous.edsm.dto;

import com.google.gson.annotations.SerializedName;

public class RanksDto {
    @SerializedName("Combat")
    private int mCombat;
    @SerializedName("Trade")
    private int mTrade;
    @SerializedName("Explore")
    private int mExplore;
    @SerializedName("CQC")
    private int mCqc;
    @SerializedName("Federation")
    private int mFederation;
    @SerializedName("Empire")
    private int mEmpire;

    public int getCombat() {
        return mCombat;
    }

    public void setCombat(int combat) {
        mCombat = combat;
    }

    public int getTrade() {
        return mTrade;
    }

    public void setTrade(int trade) {
        mTrade = trade;
    }

    public int getExplore() {
        return mExplore;
    }

    public void setExplore(int explore) {
        mExplore = explore;
    }

    public int getCqc() {
        return mCqc;
    }

    public void setCqc(int cqc) {
        mCqc = cqc;
    }

    public int getFederation() {
        return mFederation;
    }

    public void setFederation(int federation) {
        mFederation = federation;
    }

    public int getEmpire() {
        return mEmpire;
    }

    public void setEmpire(int empire) {
        mEmpire = empire;
    }
}
