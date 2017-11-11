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

public class StationDto {

    @SerializedName("id")
    private Long mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("type")
    private String mType;
    @SerializedName("distanceToArrival")
    private Double mDistanceToArrival;
    @SerializedName("allegiance")
    private String mAllegiance;
    @SerializedName("government")
    private String mGovernment;
    @SerializedName("economy")
    private String mEconomy;
    @SerializedName("haveMarket")
    private Boolean mHasMarket;
    @SerializedName("haveShipyard")
    private Boolean mHasShipyard;
    @SerializedName("controllingFaction")
    private FactionDto mControllingFaction;

    public Long getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getType() {
        return mType;
    }

    public Double getDistanceToArrival() {
        return mDistanceToArrival;
    }

    public String getAllegiance() {
        return mAllegiance;
    }

    public String getGovernment() {
        return mGovernment;
    }

    public String getEconomy() {
        return mEconomy;
    }

    public Boolean getHasMarket() {
        return mHasMarket;
    }

    public Boolean getHasShipyard() {
        return mHasShipyard;
    }

    public FactionDto getControllingFaction() {
        return mControllingFaction;
    }

    @Override
    public String toString() {
        return "StationDto{" +
                "\nmId=" + mId + '\'' +
                ",\n mName='" + mName + '\'' +
                ",\n mType='" + mType + '\'' +
                ",\n mDistanceToArrival=" + mDistanceToArrival + '\'' +
                ",\n mAllegiance='" + mAllegiance + '\'' +
                ",\n mGovernment='" + mGovernment + '\'' +
                ",\n mEconomy='" + mEconomy + '\'' +
                ",\n mHasMarket=" + mHasMarket + '\'' +
                ",\n mHasShipyard=" + mHasShipyard + '\'' +
                ",\n mControllingFaction=" + mControllingFaction + '\'' +
                '}';
    }
}
