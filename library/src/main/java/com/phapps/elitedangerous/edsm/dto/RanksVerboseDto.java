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

    @Override
    public String toString() {
        return "RanksVerboseDto{" +
                "\nmCombat='" + mCombat + '\'' +
                ",\n mTrade='" + mTrade + '\'' +
                ",\n mExplore='" + mExplore + '\'' +
                ",\n mCqc='" + mCqc + '\'' +
                ",\n mFederation='" + mFederation + '\'' +
                ",\n mEmpire='" + mEmpire + '\'' +
                '}';
    }
}
