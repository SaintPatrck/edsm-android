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

public class CoordinatesDto {
    @SerializedName("x")
    private Double mX;
    @SerializedName("y")
    private Double mY;
    @SerializedName("z")
    private Double mZ;

    public CoordinatesDto() {
    }

    public CoordinatesDto(Double x, Double y, Double z) {
        mX = x;
        mY = y;
        mZ = z;
    }

    public Double getX() {
        return mX;
    }

    public void setX(Double x) {
        mX = x;
    }

    public Double getY() {
        return mY;
    }

    public void setY(Double y) {
        mY = y;
    }

    public Double getZ() {
        return mZ;
    }

    public void setZ(Double z) {
        mZ = z;
    }

    @Override
    public String toString() {
        return "CoordinatesDto{" +
                "\nmX=" + mX + '\'' +
                ",\n mY=" + mY + '\'' +
                ",\n mZ=" + mZ + '\'' +
                '}';
    }
}
