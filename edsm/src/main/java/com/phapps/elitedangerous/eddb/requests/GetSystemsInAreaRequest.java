package com.phapps.elitedangerous.eddb.requests;

import com.phapps.elitedangerous.eddb.dto.CoordinatesDto;

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
