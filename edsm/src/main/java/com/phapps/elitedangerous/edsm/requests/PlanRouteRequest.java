package com.phapps.elitedangerous.edsm.requests;

public class PlanRouteRequest {
    private String mStartSystem;
    private String mEndSystem;
    private int mMaxJumpRange;

    public String getStartSystem() {
        return mStartSystem;
    }

    public void setStartSystem(String startSystem) {
        mStartSystem = startSystem;
    }

    public String getEndSystem() {
        return mEndSystem;
    }

    public void setEndSystem(String endSystem) {
        mEndSystem = endSystem;
    }

    public int getMaxJumpRange() {
        return mMaxJumpRange;
    }

    public void setMaxJumpRange(int maxJumpRange) {
        mMaxJumpRange = maxJumpRange;
    }
}
