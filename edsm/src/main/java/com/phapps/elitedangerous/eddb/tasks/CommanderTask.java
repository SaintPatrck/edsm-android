package com.phapps.elitedangerous.eddb.tasks;

import android.net.Uri;
import android.support.annotation.NonNull;

import com.android.volley.RequestQueue;
import com.phapps.elitedangerous.eddb.EdsmClient;

abstract class CommanderTask extends EdsmTask {

    private static final String API_COMMANDER = "commander";

    CommanderTask(RequestQueue requestQueue, EdsmClient.Server server,
            String commanderName, String apiKey) {
        super(requestQueue, server, commanderName, apiKey);
    }

    @NonNull
    Uri.Builder getUriBuilder(int version, String command) {
        return super.getUriBuilder(API_COMMANDER, version, command);
    }
}
