package com.phapps.elitedangerous.eddb.dto;

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
