package com.phapps.elitedangerous.eddb.requests;

public class SellCommanderShipRequest extends BaseCommanderRequest {
    private Integer mShipId;

    public Integer getShipId() {
        return mShipId;
    }

    public void setShipId(Integer shipId) {
        mShipId = shipId;
    }
}
