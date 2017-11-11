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

import com.phapps.elitedangerous.edsm.annotations.InventoryType;

import java.util.Map;

public class SetCommanderInventoryRequest extends BaseCommanderRequest {
    @InventoryType
    private String mType;
    private Map<String, Integer> mValues;

    @InventoryType
    public String getType() {
        return mType;
    }

    public void setType(@InventoryType String type) {
        mType = type;
    }

    public Map<String, Integer> getValues() {
        return mValues;
    }

    public void setValues(Map<String, Integer> values) {
        mValues = values;
    }
}
