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

public abstract class BaseSystemRequest {
    private boolean mShowId;
    private boolean mShowCoordinates;
    private boolean mShowPermit;
    private boolean mShowInformation;
    private boolean mShowPrimaryStar;

    public boolean showId() {
        return mShowId;
    }

    public BaseSystemRequest setShowId(boolean showId) {
        mShowId = showId;
        return this;
    }

    public boolean showCoords() {
        return mShowCoordinates;
    }

    public BaseSystemRequest setShowCoordinates(boolean showCoordinates) {
        mShowCoordinates = showCoordinates;
        return this;
    }

    public boolean showPermit() {
        return mShowPermit;
    }

    public BaseSystemRequest setShowPermit(boolean showPermit) {
        mShowPermit = showPermit;
        return this;
    }

    public boolean showInformation() {
        return mShowInformation;
    }

    public BaseSystemRequest setShowInformation(boolean showInformation) {
        mShowInformation = showInformation;
        return this;
    }

    public boolean showPrimaryStar() {
        return mShowPrimaryStar;
    }

    public BaseSystemRequest setShowPrimaryStar(boolean showPrimaryStar) {
        mShowPrimaryStar = showPrimaryStar;
        return this;
    }
}
