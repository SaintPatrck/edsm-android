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

    public String getAllegiance() {
        return mAllegiance;
    }

    public String getGovernment() {
        return mGovernment;
    }

    public String getFaction() {
        return mFaction;
    }

    public String getState() {
        return mState;
    }

    public Long getPopulation() {
        return mPopulation;
    }

    public String getSecurity() {
        return mSecurity;
    }

    public String getEconomy() {
        return mEconomy;
    }

    public String getReserve() {
        return mReserve;
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
