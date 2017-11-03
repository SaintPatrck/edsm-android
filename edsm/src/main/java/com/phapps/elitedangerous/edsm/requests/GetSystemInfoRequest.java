package com.phapps.elitedangerous.edsm.requests;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GetSystemInfoRequest extends BaseSystemRequest {
    private List<String> mSystemNames;
    private boolean mIncludeHidden;
    private boolean mOnlyFeatured;
    private boolean mOnlyKnownCoords;
    private boolean mOnlyUnknownCoords;
    private Date mLastUpdatedStartDate;
    private Date mLastUpdatedEndDate;

    public List<String> getSystemNames() {
        return mSystemNames;
    }

    private GetSystemInfoRequest setSystemName(String systemName) {
        if (mSystemNames == null) {
            mSystemNames = new ArrayList<>();
        }
        mSystemNames.clear();
        mSystemNames.add(systemName);
        return this;
    }

    public GetSystemInfoRequest setSystemNames(List<String> systemNames) {
        mSystemNames = systemNames;
        return this;
    }

    public boolean includeHidden() {
        return mIncludeHidden;
    }

    public GetSystemInfoRequest setIncludeHidden(boolean includeHidden) {
        mIncludeHidden = includeHidden;
        return this;
    }

    public boolean isOnlyFeatured() {
        return mOnlyFeatured;
    }

    public GetSystemInfoRequest setOnlyFeatured(boolean onlyFeatured) {
        mOnlyFeatured = onlyFeatured;
        return this;
    }

    public boolean isOnlyKnownCoords() {
        return mOnlyKnownCoords;
    }

    public GetSystemInfoRequest setOnlyKnownCoords(boolean onlyKnownCoords) {
        mOnlyKnownCoords = onlyKnownCoords;
        return this;
    }

    public boolean isOnlyUnknownCoords() {
        return mOnlyUnknownCoords;
    }

    public GetSystemInfoRequest setOnlyUnknownCoords(boolean onlyUnknownCoords) {
        mOnlyUnknownCoords = onlyUnknownCoords;
        return this;
    }

    public Date getLastUpdatedStartDate() {
        return mLastUpdatedStartDate;
    }

    public GetSystemInfoRequest setLastUpdatedStartDate(Date lastUpdatedStartDate) {
        mLastUpdatedStartDate = lastUpdatedStartDate;
        return this;
    }

    public Date getLastUpdatedEndDate() {
        return mLastUpdatedEndDate;
    }

    public GetSystemInfoRequest setLastUpdatedEndDate(Date lastUpdatedEndDate) {
        mLastUpdatedEndDate = lastUpdatedEndDate;
        return this;
    }
}
