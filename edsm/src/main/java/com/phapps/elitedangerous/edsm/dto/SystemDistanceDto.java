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

public class SystemDistanceDto {
    @SerializedName("id")
    private Long mId;
    @SerializedName("distance")
    private double mDistance;
    @SerializedName("name")
    private String mName;
    @SerializedName("coords")
    private CoordinatesDto mCoordinates;
    @SerializedName("coordsLocked")
    private Boolean mCoordsLocked;
    @SerializedName("requirePermit")
    private Boolean mRequirePermit;

    public Long getId() {
        return mId;
    }

    public double getDistance() {
        return mDistance;
    }

    public String getName() {
        return mName;
    }

    public CoordinatesDto getCoordinates() {
        return mCoordinates;
    }

    public Boolean getCoordsLocked() {
        return mCoordsLocked;
    }

    public Boolean getRequirePermit() {
        return mRequirePermit;
    }

    @Override
    public String toString() {
        return "SystemDistanceDto{" +
                "\nmId=" + mId + '\'' +
                ",\n mDistance=" + mDistance + '\'' +
                ",\n mName='" + mName + '\'' +
                ",\n mCoordinates=" + mCoordinates + '\'' +
                ",\n mCoordsLocked=" + mCoordsLocked + '\'' +
                ",\n mRequirePermit=" + mRequirePermit + '\'' +
                '}';
    }
}
