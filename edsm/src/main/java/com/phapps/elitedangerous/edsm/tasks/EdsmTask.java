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
