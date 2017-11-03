package com.phapps.elitedangerous.edsm.dto;

import com.google.gson.annotations.SerializedName;

public class StationDto {

    @SerializedName("id")
    private Long mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("type")
    private String mType;
    @SerializedName("distanceToArrival")
    private Double mDistanceToArrival;
    @SerializedName("allegiance")
    private String mAllegiance;
    @SerializedName("government")
    private String mGovernment;
    @SerializedName("economy")
    private String mEconomy;
    @SerializedName("haveMarket")
    private Boolean mHasMarket;
    @SerializedName("haveShipyard")
    private Boolean mHasShipyard;
    @SerializedName("controllingFaction")
    private FactionDto mControllingFaction;

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public Double getDistanceToArrival() {
        return mDistanceToArrival;
    }

    public void setDistanceToArrival(Double distanceToArrival) {
        mDistanceToArrival = distanceToArrival;
    }

    public String getAllegiance() {
        return mAllegiance;
    }

    public void setAllegiance(String allegiance) {
        mAllegiance = allegiance;
    }

    public String getGovernment() {
        return mGovernment;
    }

    public void setGovernment(String government) {
        mGovernment = government;
    }

    public String getEconomy() {
        return mEconomy;
    }

    public void setEconomy(String economy) {
        mEconomy = economy;
    }

    public Boolean getHasMarket() {
        return mHasMarket;
    }

    public void setHasMarket(Boolean hasMarket) {
        mHasMarket = hasMarket;
    }

    public Boolean getHasShipyard() {
        return mHasShipyard;
    }

    public void setHasShipyard(Boolean hasShipyard) {
        mHasShipyard = hasShipyard;
    }

    public FactionDto getControllingFaction() {
        return mControllingFaction;
    }

    public void setControllingFaction(FactionDto controllingFaction) {
        mControllingFaction = controllingFaction;
    }

    @Override
    public String toString() {
        return "StationDto{" +
                "\nmId=" + mId + '\'' +
                ",\n mName='" + mName + '\'' +
                ",\n mType='" + mType + '\'' +
                ",\n mDistanceToArrival=" + mDistanceToArrival + '\'' +
                ",\n mAllegiance='" + mAllegiance + '\'' +
                ",\n mGovernment='" + mGovernment + '\'' +
                ",\n mEconomy='" + mEconomy + '\'' +
                ",\n mHasMarket=" + mHasMarket + '\'' +
                ",\n mHasShipyard=" + mHasShipyard + '\'' +
                ",\n mControllingFaction=" + mControllingFaction + '\'' +
                '}';
    }
}
