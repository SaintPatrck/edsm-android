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

package com.phapps.elitedangerous.edsm.requests;

import com.phapps.elitedangerous.edsm.dto.CoordinatesDto;

public class GetSystemsInAreaRequest extends BaseSystemRequest {

    public static final int SHAPE_SPHERE = 0;
    public static final int SHAPE_CUBE = 1;

    private int mShape;
    private String mSystemName;
    private CoordinatesDto mCoordinates;
    private Double mMinRadius;
    private Double mRadius;
    private Double mSize;

    public int getShape() {
        return mShape;
    }

    public GetSystemsInAreaRequest setShape(int shape) {
        mShape = shape;
        return this;
    }

    public String getSystemName() {
        return mSystemName;
    }

    public GetSystemsInAreaRequest setSystemName(String systemName) {
        mSystemName = systemName;
        return this;
    }

    public CoordinatesDto getCoordinates() {
        return mCoordinates;
    }

    public GetSystemsInAreaRequest setCoordinates(CoordinatesDto coordinates) {
        mCoordinates = coordinates;
        return this;
    }

    public Double getMinRadius() {
        return mMinRadius;
    }

    public GetSystemsInAreaRequest setMinRadius(Double minRadius) {
        mMinRadius = minRadius;
        return this;
    }

    public Double getRadius() {
        return mRadius;
    }

    public GetSystemsInAreaRequest setRadius(Double radius) {
        mRadius = radius;
        return this;
    }

    public Double getSize() {
        return mSize;
    }

    public GetSystemsInAreaRequest setSize(Double size) {
        mSize = size;
        return this;
    }
}
