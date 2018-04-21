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

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.phapps.elitedangerous.edsm.network.AlwaysListTypeAdapterFactory;

import java.util.Date;
import java.util.List;

public class SystemDto {
    @SerializedName("id")
    private Long mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("coords")
    private CoordinatesDto mCoordinates;
    @SerializedName("duplicates")
    private Long mDuplicates;
    @SerializedName("requirePermit")
    private Boolean mRequirePermit;
    @SerializedName("permitName")
    private String mPermitName;
    @JsonAdapter(AlwaysListTypeAdapterFactory.class)
    @SerializedName("information")
    private List<InformationDto> mInformation;
    @SerializedName("primaryStar")
    private StarDto mStar;
    @SerializedName("hidden_at")
    private Date mHiddenAt;
    @SerializedName("mergedTo")
    private Long mMergedTo;

    public Long getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public CoordinatesDto getCoordinates() {
        return mCoordinates;
    }

    public Long getDuplicates() {
        return mDuplicates;
    }

    public Boolean getRequirePermit() {
        return mRequirePermit;
    }

    public String getPermitName() {
        return mPermitName;
    }

    public List<InformationDto> getInformation() {
        return mInformation;
    }

    public StarDto getStar() {
        return mStar;
    }

    public Date getHiddenAt() {
        return mHiddenAt;
    }

    public Long getMergedTo() {
        return mMergedTo;
    }

    @Override
    public String toString() {
        return "SystemDto{" +
                "\nmId=" + mId + '\'' +
                ",\n mName='" + mName + '\'' +
                ",\n mCoordinates=" + mCoordinates + '\'' +
                ",\n mDuplicates=" + mDuplicates + '\'' +
                ",\n mRequirePermit=" + mRequirePermit + '\'' +
                ",\n mPermitName='" + mPermitName + '\'' +
                ",\n mInformation=" + mInformation + '\'' +
                ",\n mStar=" + mStar + '\'' +
                ",\n mHiddenAt=" + mHiddenAt + '\'' +
                ",\n mMergedTo=" + mMergedTo + '\'' +
                '}';
    }
}
