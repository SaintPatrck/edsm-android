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

public class ProgressDto {
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

    @Override
    public String toString() {
        return "ProgressDto{" +
                "\nmCombat=" + mCombat + '\'' +
                ",\n mTrade=" + mTrade + '\'' +
                ",\n mExplore=" + mExplore + '\'' +
                ",\n mCqc=" + mCqc + '\'' +
                ",\n mFederation=" + mFederation + '\'' +
                ",\n mEmpire=" + mEmpire + '\'' +
                '}';
    }
}
