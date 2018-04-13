/*
 * Copyright (c) 2017.
 *
 * Copyright 2017 Patrick Honkonen
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.phapps.elitedangerous.edsm.requests;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class GetSystemInfoRequest extends BaseSystemRequest {

    private final List<String> mSystemNames = new ArrayList<>();
    private boolean mIncludeHidden;
    private boolean mOnlyFeatured;
    private boolean mOnlyKnownCoords;
    private boolean mOnlyUnknownCoords;
    private Date mLastUpdatedStartDate;
    private Date mLastUpdatedEndDate;

    @NonNull
    public List<String> getSystemNames() {
        return mSystemNames;
    }

    private GetSystemInfoRequest setSystemName(@NonNull String systemName) {
        mSystemNames.clear();
        mSystemNames.add(systemName);
        return this;
    }

    public GetSystemInfoRequest setSystemNames(@NonNull List<String> systemNames) {
        mSystemNames.clear();
        Collections.copy(mSystemNames, systemNames);
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
