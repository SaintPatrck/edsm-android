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

public class CommanderDto {
    @SerializedName("msgnum")
    private int mMessageNumber;
    @SerializedName("msg")
    private String mMessage;
    @SerializedName("ranks")
    private RanksDto mRanks;
    @SerializedName("progress")
    private ProgressDto mProgress;
    @SerializedName("ranksVerbose")
    private RanksVerboseDto mRanksVerbose;

    public int getMessageNumber() {
        return mMessageNumber;
    }

    public void setMessageNumber(int messageNumber) {
        mMessageNumber = messageNumber;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public RanksDto getRanks() {
        return mRanks;
    }

    public void setRanks(RanksDto ranks) {
        mRanks = ranks;
    }

    public ProgressDto getProgress() {
        return mProgress;
    }

    public void setProgress(ProgressDto progress) {
        mProgress = progress;
    }

    public RanksVerboseDto getRanksVerbose() {
        return mRanksVerbose;
    }

    public void setRanksVerbose(RanksVerboseDto ranksVerbose) {
        mRanksVerbose = ranksVerbose;
    }

    @Override
    public String toString() {
        return "CommanderDto{" +
                "\nmMessageNumber=" + mMessageNumber + '\'' +
                ",\n mMessage='" + mMessage + '\'' +
                ",\n mRanks=" + mRanks + '\'' +
                ",\n mProgress=" + mProgress + '\'' +
                ",\n mRanksVerbose=" + mRanksVerbose + '\'' +
                '}';
    }
}
