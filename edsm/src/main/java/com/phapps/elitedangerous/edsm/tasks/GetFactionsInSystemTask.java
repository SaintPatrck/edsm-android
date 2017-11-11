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

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.phapps.elitedangerous.edsm.EdsmClient;
import com.phapps.elitedangerous.edsm.callbacks.GetFactionsInSystemCallbacks;
import com.phapps.elitedangerous.edsm.dto.SystemFactionsDto;
import com.phapps.elitedangerous.edsm.network.GsonRequest;
import com.phapps.elitedangerous.edsm.requests.GetFactionsInSystemRequest;

public class GetFactionsInSystemTask extends EdsmTask {
    private final GetFactionsInSystemRequest mRequest;
    private final GetFactionsInSystemCallbacks mCallbacks;

    public GetFactionsInSystemTask(RequestQueue requestQueue, EdsmClient.Server server,
            GetFactionsInSystemRequest request,
            GetFactionsInSystemCallbacks callbacks) {
        super(requestQueue, server);
        mRequest = request;
        mCallbacks = callbacks;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        Uri.Builder builder = getUriBuilder("system", VERSION_1, "factions");
        builder.appendQueryParameter("systemName", mRequest.getSystemName());
        if (mRequest.getSystemId() != null) {
            builder.appendQueryParameter("systemId", String.valueOf(mRequest.getSystemId()));
        }

        if (mRequest.isShowHistory()) {
            builder.appendQueryParameter("showHistory", "1");
        }

        GsonRequest<SystemFactionsDto> gsonRequest = new GsonRequest<>(builder.build().toString(),
                SystemFactionsDto.class,
                getHeaders(),
                new Response.Listener<SystemFactionsDto>() {
                    @Override
                    public void onResponse(SystemFactionsDto response) {
                        if (response != null) {
                            mCallbacks.onSuccess(response);
                        } else {
                            mCallbacks.onFail("No matching system found");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        mCallbacks.onError();
                    }
                });

        mRequestQueue.add(gsonRequest);

        return null;
    }
}
