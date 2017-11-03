package com.phapps.elitedangerous.edsm.requests;

import com.phapps.elitedangerous.edsm.annotations.InventoryType;

public class GetCommanderInventoryRequest extends BaseCommanderRequest {
    @InventoryType
    private String mType;

    @InventoryType
    public String getType() {
        return mType;
    }

    public void setType(@InventoryType String type) {
        mType = type;
    }
}
