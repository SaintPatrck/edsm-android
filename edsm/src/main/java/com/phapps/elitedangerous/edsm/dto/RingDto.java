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

public class RingDto {

    @SerializedName("name")
    private String mName;
    @SerializedName("type")
    private String mType;
    @SerializedName("mass")
    private Long mMass;
    @SerializedName("innerRadius")
    private Integer mInnerRadius;
    @SerializedName("outerRadius")
    private Integer mOuterRadius;

    public String getName() {
        return mName;
    }

    public String getType() {
        return mType;
    }

    public Long getMass() {
        return mMass;
    }

    public Integer getInnerRadius() {
        return mInnerRadius;
    }

    public Integer getOuterRadius() {
        return mOuterRadius;
    }

    @Override
    public String toString() {
        return "RingDto{" +
                "\nmName='" + mName + '\'' +
                ",\n mType='" + mType + '\'' +
                ",\n mMass=" + mMass + '\'' +
                ",\n mInnerRadius=" + mInnerRadius + '\'' +
                ",\n mOuterRadius=" + mOuterRadius + '\'' +
                '}';
    }
}
