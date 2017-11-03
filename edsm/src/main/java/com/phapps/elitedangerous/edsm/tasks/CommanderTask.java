package com.phapps.elitedangerous.edsm.tasks;

import android.net.Uri;
import android.support.annotation.NonNull;

import com.android.volley.RequestQueue;
import com.phapps.elitedangerous.edsm.EdsmClient;

abstract class CommanderTask extends EdsmTask {

    private static final String API_COMMANDER = "commander";

    final String mCommanderName;
    final String mApiKey;

    CommanderTask(RequestQueue requestQueue, EdsmClient.Server server,
            String commanderName, String apiKey) {
        super(requestQueue, server);
        mApiKey = apiKey;
        mCommanderName = commanderName;
    }

    @NonNull
    Uri.Builder getUriBuilder(int version, String command) {
        return super.getUriBuilder(API_COMMANDER, version, command);
    }
}
