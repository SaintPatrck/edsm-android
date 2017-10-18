package com.phapps.elitedangerous.eddb.requests;

import com.phapps.elitedangerous.eddb.annotations.InventoryType;

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
