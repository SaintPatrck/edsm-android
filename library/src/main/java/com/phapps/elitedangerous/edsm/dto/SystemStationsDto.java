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

public class SystemStationsDto {
    @SerializedName("id")
    private Long mSystemId;
    @SerializedName("name")
    private String mSystemName;
    @SerializedName("stations")
    private StationDto[] mStations;

    public Long getSystemId() {
        return mSystemId;
    }

    public void setSystemId(Long systemId) {
        mSystemId = systemId;
    }

    public String getSystemName() {
        return mSystemName;
    }

    public void setSystemName(String systemName) {
        mSystemName = systemName;
    }

    public StationDto[] getStations() {
        return mStations;
    }

    public void setStations(StationDto[] stations) {
        mStations = stations;
    }

    @Override
    public String toString() {
        return "SystemStationsDto{" +
                "\nmSystemId=" + mSystemId + '\'' +
                ",\n mSystemName='" + mSystemName + '\'' +
                ",\n mStations=" + Arrays.toString(mStations) +
                '}';
    }
}
