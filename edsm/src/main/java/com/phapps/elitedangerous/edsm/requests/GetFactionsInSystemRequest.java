package com.phapps.elitedangerous.edsm.requests;

public class GetFactionsInSystemRequest {
    private String mSystemName;
    private Long mSystemId;
    private boolean mShowHistory;

    public String getSystemName() {
        return mSystemName;
    }

    public void setSystemName(String systemName) {
        mSystemName = systemName;
    }

    public Long getSystemId() {
        return mSystemId;
    }

    public void setSystemId(Long systemId) {
        mSystemId = systemId;
    }

    public boolean isShowHistory() {
        return mShowHistory;
    }

    public void setShowHistory(boolean showHistory) {
        mShowHistory = showHistory;
    }
}
