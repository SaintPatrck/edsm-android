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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.phapps.elitedangerous.edsm.EdsmClient;
import com.phapps.elitedangerous.edsm.callbacks.PlanRouteCallbacks;
import com.phapps.elitedangerous.edsm.dto.SystemJumpDto;
import com.phapps.elitedangerous.edsm.requests.PlanRouteRequest;

public class PlanRouteTask extends EdsmTask {

    private final PlanRouteRequest mRequest;
    private final PlanRouteCallbacks mCallbacks;

    public PlanRouteTask(RequestQueue requestQueue, EdsmClient.Server server, PlanRouteRequest request, PlanRouteCallbacks callbacks) {
        super(requestQueue, server);
        mRequest = request;
        mCallbacks = callbacks;
    }

    @Override
    protected Void doInBackground(Void... voids) {

        Uri.Builder builder = Uri.parse("https://www.edsm.net/").buildUpon()
                .appendPath("en").appendPath("map").appendPath("planner").appendPath("index")
                .appendPath("endSystem").appendPath(mRequest.getEndSystem())
                .appendPath("startSystem").appendPath(mRequest.getStartSystem())
                .appendPath("maxJumpRange")
                .appendPath(String.valueOf(mRequest.getMaxJumpRange()));

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                builder.build().toString(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            int startIndex = response.indexOf("var currentRoute");
                            startIndex = response.indexOf("[", startIndex);
                            int endIndex = response.indexOf(";", startIndex);
                            String routeJson = response.substring(startIndex, endIndex);
                            mCallbacks.onSuccess(new Gson().fromJson(routeJson, SystemJumpDto[].class));
                        } catch (Exception e) {
                            mCallbacks.onFail("Unexpected response");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        mCallbacks.onError();
                    }
                });
        mRequestQueue.add(stringRequest);

        return null;
    }
}
