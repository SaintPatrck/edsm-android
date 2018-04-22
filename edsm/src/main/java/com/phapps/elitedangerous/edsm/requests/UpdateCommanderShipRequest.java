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

import com.phapps.elitedangerous.edsm.annotations.ShipType;

public class UpdateCommanderShipRequest extends BaseCommanderRequest {
    private Integer mShipId;
    private String mShipName;
    private String mShipIdent;
    @ShipType
    private String mType;
    private String mPaintJob;
    private String mCargoQuantity;
    private String mCargoCapacity;
    private String mFuelMainLevel;
    private String mFuelMainCapacity;
    private String mFuelReserveLevel;
    private String mFuelReserveCapacity;
    private String mLinkToCoriollis;
    private String mLinkToEdShipyard;

    public Integer getShipId() {
        return mShipId;
    }

    public void setShipId(Integer shipId) {
        mShipId = shipId;
    }

    public String getShipName() {
        return mShipName;
    }

    public void setShipName(String shipName) {
        mShipName = shipName;
    }

    public String getShipIdent() {
        return mShipIdent;
    }

    public void setShipIdent(String shipIdent) {
        mShipIdent = shipIdent;
    }

    @ShipType
    public String getType() {
        return mType;
    }

    public void setType(@ShipType String type) {
        mType = type;
    }

    public String getPaintJob() {
        return mPaintJob;
    }

    public void setPaintJob(String paintJob) {
        mPaintJob = paintJob;
    }

    public String getCargoQuantity() {
        return mCargoQuantity;
    }

    public void setCargoQuantity(String cargoQuantity) {
        mCargoQuantity = cargoQuantity;
    }

    public String getCargoCapacity() {
        return mCargoCapacity;
    }

    public void setCargoCapacity(String cargoCapacity) {
        mCargoCapacity = cargoCapacity;
    }

    public String getFuelMainLevel() {
        return mFuelMainLevel;
    }

    public void setFuelMainLevel(String fuelMainLevel) {
        mFuelMainLevel = fuelMainLevel;
    }

    public String getFuelMainCapacity() {
        return mFuelMainCapacity;
    }

    public void setFuelMainCapacity(String fuelMainCapacity) {
        mFuelMainCapacity = fuelMainCapacity;
    }

    public String getFuelReserveLevel() {
        return mFuelReserveLevel;
    }

    public void setFuelReserveLevel(String fuelReserveLevel) {
        mFuelReserveLevel = fuelReserveLevel;
    }

    public String getFuelReserveCapacity() {
        return mFuelReserveCapacity;
    }

    public void setFuelReserveCapacity(String fuelReserveCapacity) {
        mFuelReserveCapacity = fuelReserveCapacity;
    }

    public String getLinkToCoriollis() {
        return mLinkToCoriollis;
    }

    public void setLinkToCoriollis(String linkToCoriollis) {
        mLinkToCoriollis = linkToCoriollis;
    }

    public String getLinkToEdShipyard() {
        return mLinkToEdShipyard;
    }

    public void setLinkToEdShipyard(String linkToEdShipyard) {
        mLinkToEdShipyard = linkToEdShipyard;
    }
}
