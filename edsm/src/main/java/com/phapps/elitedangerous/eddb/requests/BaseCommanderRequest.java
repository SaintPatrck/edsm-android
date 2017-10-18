package com.phapps.elitedangerous.eddb.requests;

abstract class BaseCommanderRequest {
    private String mCommanderName;
    private String mApiKey;

    public String getCommanderName() {
        return mCommanderName;
    }

    public void setCommanderName(String commanderName) {
        mCommanderName = commanderName;
    }

    public String getApiKey() {
        return mApiKey;
    }

    public void setApiKey(String apiKey) {
        mApiKey = apiKey;
    }
}
