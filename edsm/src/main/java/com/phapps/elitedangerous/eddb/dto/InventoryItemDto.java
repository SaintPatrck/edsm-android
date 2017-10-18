package com.phapps.elitedangerous.eddb.dto;

import com.google.gson.annotations.SerializedName;
import com.phapps.elitedangerous.eddb.annotations.InventoryType;

public class InventoryItemDto {
    @SerializedName("type")
    @InventoryType
    private String mType;
    @SerializedName("name")
    private String mName;
    @SerializedName("qty")
    private Integer mQuantity;

    @InventoryType
    public String getType() {
        return mType;
    }

    public void setType(@InventoryType String type) {
        mType = type;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Integer getQuantity() {
        return mQuantity;
    }

    public void setQuantity(Integer quantity) {
        mQuantity = quantity;
    }
}
