package com.phapps.elitedangerous.edsm.dto;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.Map;

public class FactionDto {

    @SerializedName("id")
    private Long mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("allegiance")
    private String mAllegiance;
    @SerializedName("government")
    private String mGovernment;
    @SerializedName("influence")
    private Double mInfluence;
    @SerializedName("influenceHistory")
    private Map<String, Double> mInfluenceHistory;
    @SerializedName("state")
    private String mState;
    @SerializedName("stateHistory")
    private Map<String, String> mStateHistory;
    @SerializedName("recoveringStates")
    private FactionStateDto[] mRecoveringStates;
    @SerializedName("pendingStates")
    private FactionStateDto[] mPendingStates;
    @SerializedName("isPlayer")
    private Boolean mIsPlayer;

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

    public Double getInfluence() {
        return mInfluence;
    }

    public void setInfluence(Double influence) {
        mInfluence = influence;
    }

    public Map<String, Double> getInfluenceHistory() {
        return mInfluenceHistory;
    }

    public void setInfluenceHistory(Map<String, Double> influenceHistory) {
        mInfluenceHistory = influenceHistory;
    }

    public String getState() {
        return mState;
    }

    public void setState(String state) {
        mState = state;
    }

    public Map<String, String> getStateHistory() {
        return mStateHistory;
    }

    public void setStateHistory(Map<String, String> stateHistory) {
        mStateHistory = stateHistory;
    }

    public FactionStateDto[] getRecoveringStates() {
        return mRecoveringStates;
    }

    public void setRecoveringStates(FactionStateDto[] recoveringStates) {
        mRecoveringStates = recoveringStates;
    }

    public FactionStateDto[] getPendingStates() {
        return mPendingStates;
    }

    public void setPendingStates(FactionStateDto[] pendingStates) {
        mPendingStates = pendingStates;
    }

    public Boolean getPlayer() {
        return mIsPlayer;
    }

    public void setPlayer(Boolean player) {
        mIsPlayer = player;
    }

    @Override
    public String toString() {
        return "FactionDto{" +
                "\nmId=" + mId + '\'' +
                ",\n mName='" + mName + '\'' +
                ",\n mInfluence=" + mInfluence + '\'' +
                ",\n mInfluenceHistory=" + mInfluenceHistory + '\'' +
                ",\n mState='" + mState + '\'' +
                ",\n mStateHistory=" + mStateHistory + '\'' +
                ",\n mRecoveringStates=" + Arrays.toString(mRecoveringStates) + '\'' +
                ",\n mPendingStates=" + Arrays.toString(mPendingStates) + '\'' +
                ",\n mIsPlayer=" + mIsPlayer + '\'' +
                '}';
    }
}
