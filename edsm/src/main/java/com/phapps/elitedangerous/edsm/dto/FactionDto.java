package com.phapps.elitedangerous.edsm.dto;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.Map;

public class FactionDto {

    @SerializedName("id")
    private Long mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("influence")
    private Double mInfluence;
    @SerializedName("influenceHistory")
    private Map<Date, Double> mInfluenceHistory;
    @SerializedName("state")
    private String mState;
    @SerializedName("stateHistory")
    private Map<Date, String> mStateHistory;
    @SerializedName("recoveringStates")
    private Map<Date, String> mRecoveringStates;
    @SerializedName("pendingStates")
    private Map<String, Integer> mPendingStates;
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

    public Double getInfluence() {
        return mInfluence;
    }

    public void setInfluence(Double influence) {
        mInfluence = influence;
    }

    public Map<Date, Double> getInfluenceHistory() {
        return mInfluenceHistory;
    }

    public void setInfluenceHistory(Map<Date, Double> influenceHistory) {
        mInfluenceHistory = influenceHistory;
    }

    public String getState() {
        return mState;
    }

    public void setState(String state) {
        mState = state;
    }

    public Map<Date, String> getStateHistory() {
        return mStateHistory;
    }

    public void setStateHistory(Map<Date, String> stateHistory) {
        mStateHistory = stateHistory;
    }

    public Map<Date, String> getRecoveringStates() {
        return mRecoveringStates;
    }

    public void setRecoveringStates(Map<Date, String> recoveringStates) {
        mRecoveringStates = recoveringStates;
    }

    public Map<String, Integer> getPendingStates() {
        return mPendingStates;
    }

    public void setPendingStates(Map<String, Integer> pendingStates) {
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
                ",\n mRecoveringStates=" + mRecoveringStates + '\'' +
                ",\n mPendingStates=" + mPendingStates + '\'' +
                ",\n mIsPlayer=" + mIsPlayer + '\'' +
                '}';
    }
}
