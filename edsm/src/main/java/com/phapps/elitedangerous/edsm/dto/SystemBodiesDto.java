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

public class SystemBodiesDto {
    @SerializedName("id")
    private Long mSystemId;
    @SerializedName("name")
    private String mSystemName;
    @SerializedName("bodies")
    private BodyDto[] mBodies;

    public Long getSystemId() {
        return mSystemId;
    }

    public String getSystemName() {
        return mSystemName;
    }

    public BodyDto[] getBodies() {
        return mBodies;
    }

    @Override
    public String toString() {
        return "SystemBodiesDto{" +
                "\nmSystemId=" + mSystemId + '\'' +
                ",\n mSystemName='" + mSystemName + '\'' +
                ",\n mBodies=" + Arrays.toString(mBodies) +
                '}';
    }
}
