package com.phapps.elitedangerous.edsm.tasks;

import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.android.volley.RequestQueue;
import com.phapps.elitedangerous.edsm.EdsmClient;

import java.util.HashMap;
import java.util.Map;

abstract class EdsmTask extends AsyncTask<Void, Void, Void> {

    static final int VERSION_1 = 1;

    static final String PARAM_COMMANDER_NAME = "commanderName";
    static final String PARAM_API_KEY = "apiKey";

    private EdsmClient.Server mServer;

    final RequestQueue mRequestQueue;


    EdsmTask(RequestQueue requestQueue, EdsmClient.Server server) {
        mServer = server;
        mRequestQueue = requestQueue;
    }

    @NonNull
    Uri.Builder getUriBuilder(String api, int version, String command) {
        String apiPath;
        if (api != null) {
            apiPath = "-" + api;
        } else {
            apiPath = "";
        }
        return Uri.parse(mServer.address).buildUpon().appendPath("api" + apiPath + "-v" + version)
                .appendPath(command);
    }

    Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept-Encoding", "gzip");
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        return headers;
    }
}
