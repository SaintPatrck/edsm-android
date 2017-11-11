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
