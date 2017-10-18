package com.phapps.elitedangerous.eddb.dto;

import com.google.gson.annotations.SerializedName;

public class InventorySummaryDto {
    @SerializedName("msgnum")
    private Integer mMessageNumber;
    @SerializedName("msg")
    private String mMessage;
    @SerializedName("materials")
    private InventoryItemDto[] mMaterials;

    public Integer getMessageNumber() {
        return mMessageNumber;
    }

    public void setMessageNumber(Integer messageNumber) {
        mMessageNumber = messageNumber;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public InventoryItemDto[] getMaterials() {
        return mMaterials;
    }

    public void setMaterials(InventoryItemDto[] materials) {
        mMaterials = materials;
    }
}
