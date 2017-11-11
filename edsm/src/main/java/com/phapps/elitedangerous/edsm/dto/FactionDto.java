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

import java.util.Arrays;
import java.util.Map;

public class FactionDto {

    @SerializedName("id")
    private Long mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("allegiance")
    private String mAllegiance;
    @SerializedName("government")
    private String mGovernment;
    @SerializedName("influence")
    private Double mInfluence;
    @SerializedName("influenceHistory")
    private Map<String, Double> mInfluenceHistory;
    @SerializedName("state")
    private String mState;
    @SerializedName("stateHistory")
    private Map<String, String> mStateHistory;
    @SerializedName("recoveringStates")
    private FactionStateDto[] mRecoveringStates;
    @SerializedName("pendingStates")
    private FactionStateDto[] mPendingStates;
    @SerializedName("isPlayer")
    private Boolean mIsPlayer;

    public Long getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getAllegiance() {
        return mAllegiance;
    }

    public String getGovernment() {
        return mGovernment;
    }

    public Double getInfluence() {
        return mInfluence;
    }

    public Map<String, Double> getInfluenceHistory() {
        return mInfluenceHistory;
    }

    public String getState() {
        return mState;
    }

    public Map<String, String> getStateHistory() {
        return mStateHistory;
    }

    public FactionStateDto[] getRecoveringStates() {
        return mRecoveringStates;
    }

    public FactionStateDto[] getPendingStates() {
        return mPendingStates;
    }

    public Boolean getPlayer() {
        return mIsPlayer;
    }

    @Override
    public String toString() {
        return "FactionDto{" +
                "\nmId=" + mId + '\'' +
                ",\n mName='" + mName + '\'' +
                ",\n mInfluence=" + mInfluence + '\'' +
                ",\n mInfluenceHistory=" + mInfluenceHistory + '\'' +
                ",\n mState='" + mState + '\'' +
                ",\n mStateHistory=" + mStateHistory + '\'' +
                ",\n mRecoveringStates=" + Arrays.toString(mRecoveringStates) + '\'' +
                ",\n mPendingStates=" + Arrays.toString(mPendingStates) + '\'' +
                ",\n mIsPlayer=" + mIsPlayer + '\'' +
                '}';
    }
}
