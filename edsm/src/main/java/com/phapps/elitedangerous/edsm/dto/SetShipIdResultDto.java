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

package com.phapps.elitedangerous.edsm.dto;

import com.google.gson.annotations.SerializedName;

public class SetShipIdResultDto {
    @SerializedName("msgnum")
    private Integer mMessageNumber;
    @SerializedName("msg")
    private String mMessage;
    @SerializedName("inDatabase")
    private Boolean mInDatabase;

    public Integer getMessageNumber() {
        return mMessageNumber;
    }

    public void setMessageNumber(Integer messageNumber) {
        mMessageNumber = messageNumber;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    /**
     * States if the current {@code shipId} is in the EDSM database already or if you need to add the ship.
     *
     * @return true if the ship is in the database already, false otherwise.
     */
    public Boolean getInDatabase() {
        return mInDatabase;
    }

    public void setInDatabase(Boolean inDatabase) {
        mInDatabase = inDatabase;
    }

    @Override
    public String toString() {
        return "SetShipIdResultDto{" +
                "\nmMessageNumber=" + mMessageNumber + '\'' +
                ",\n mMessage='" + mMessage + '\'' +
                ",\n mInDatabase=" + mInDatabase + '\'' +
                '}';
    }
}
