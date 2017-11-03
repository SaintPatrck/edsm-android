package com.phapps.elitedangerous.edsm.requests;

import com.phapps.elitedangerous.edsm.annotations.InventoryType;

import java.util.Map;

public class SetCommanderInventoryRequest extends BaseCommanderRequest {
    @InventoryType
    private String mType;
    private Map<String, Integer> mValues;

    @InventoryType
    public String getType() {
        return mType;
    }

    public void setType(@InventoryType String type) {
        mType = type;
    }

    public Map<String, Integer> getValues() {
        return mValues;
    }

    public void setValues(Map<String, Integer> values) {
        mValues = values;
    }
}
