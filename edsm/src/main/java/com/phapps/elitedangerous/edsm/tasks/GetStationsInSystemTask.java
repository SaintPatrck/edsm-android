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
import com.phapps.elitedangerous.edsm.callbacks.GetStationsInSystemCallbacks;
import com.phapps.elitedangerous.edsm.dto.SystemStationsDto;
import com.phapps.elitedangerous.edsm.network.GsonRequest;
import com.phapps.elitedangerous.edsm.requests.GetStationsInSystemRequest;

public class GetStationsInSystemTask extends EdsmTask {
    private final GetStationsInSystemRequest mRequest;
    private final GetStationsInSystemCallbacks mCallbacks;

    public GetStationsInSystemTask(RequestQueue requestQueue, EdsmClient.Server server,
            GetStationsInSystemRequest request,
            GetStationsInSystemCallbacks callbacks) {
        super(requestQueue, server);
        mRequest = request;
        mCallbacks = callbacks;
    }

    @Override
    protected Void doInBackground(Void... voids) {

        Uri.Builder builder = getUriBuilder("system", VERSION_1, "stations");
        builder.appendQueryParameter("systemName", mRequest.getSystemName());

        if (mRequest.getSystemId() != null) {
            builder.appendQueryParameter("systemId", String.valueOf(mRequest.getSystemId()));
        }

        GsonRequest<SystemStationsDto> request = new GsonRequest<>(builder.build().toString(),
                SystemStationsDto.class,
                getHeaders(),
                new Response.Listener<SystemStationsDto>() {
                    @Override
                    public void onResponse(SystemStationsDto response) {
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

        mRequestQueue.add(request);

        return null;
    }
}
