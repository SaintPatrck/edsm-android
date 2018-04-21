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

import java.util.Date;

public class DistancesSearchResultsDto {
    @SerializedName("id")
    private Long mId;
    @SerializedName("sys1")
    private SystemDto mSystem1;
    @SerializedName("sys2")
    private SystemDto mSystem2;
    @SerializedName("distance")
    private Double mDistance;
    @SerializedName("hidden_at")
    private Date mHiddenAt;

    public Long getId() {
        return mId;
    }

    public SystemDto getSystem1() {
        return mSystem1;
    }

    public SystemDto getSystem2() {
        return mSystem2;
    }

    public Double getDistance() {
        return mDistance;
    }

    public Date getHiddenAt() {
        return mHiddenAt;
    }

    @Override
    public String toString() {
        return "DistancesSearchResultsDto{" +
                "\nmId=" + mId + '\'' +
                ",\n mSystem1=" + mSystem1 + '\'' +
                ",\n mSystem2=" + mSystem2 + '\'' +
                ",\n mDistance=" + mDistance + '\'' +
                ",\n mHiddenAt=" + mHiddenAt + '\'' +
                '}';
    }
}
