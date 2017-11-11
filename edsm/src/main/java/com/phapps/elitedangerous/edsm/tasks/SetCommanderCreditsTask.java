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
import com.phapps.elitedangerous.edsm.callbacks.SetCommanderCreditsCallbacks;
import com.phapps.elitedangerous.edsm.dto.UpdateResultDto;
import com.phapps.elitedangerous.edsm.network.GsonRequest;
import com.phapps.elitedangerous.edsm.requests.SetCommanderCreditsRequest;

public class SetCommanderCreditsTask extends CommanderTask {

    private static final String COMMAND = "set-credits";
    private static final String PARAM_COMMANDER_NAME = "commanderName";
    private static final String PARAM_API_KEY = "apiKey";
    private static final String PARAM_BALANCE = "balance";
    private static final String PARAM_LOAN = "loan";

    private final SetCommanderCreditsRequest mRequest;
    private final SetCommanderCreditsCallbacks mCallbacks;

    public SetCommanderCreditsTask(RequestQueue requestQueue, EdsmClient.Server server,
            SetCommanderCreditsRequest request,
            SetCommanderCreditsCallbacks callbacks) {
        super(requestQueue, server, request.getCommanderName(), request.getApiKey());
        mRequest = request;
        mCallbacks = callbacks;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        Uri.Builder builder = getUriBuilder(VERSION_1, COMMAND);
        builder.appendQueryParameter(PARAM_COMMANDER_NAME, mRequest.getCommanderName())
                .appendQueryParameter(PARAM_API_KEY, mRequest.getApiKey())
                .appendQueryParameter(PARAM_BALANCE, mRequest.getBalance().toString());

        if (mRequest.getLoan() != null) {
            builder.appendQueryParameter(PARAM_LOAN, mRequest.getLoan().toString());
        }

        GsonRequest<UpdateResultDto> gsonRequest = new GsonRequest<>(builder.build().toString(),
                UpdateResultDto.class,
                getHeaders(),
                new Response.Listener<UpdateResultDto>() {
                    @Override
                    public void onResponse(UpdateResultDto response) {
                        if (response.getMessageNumber() == 100) {
                            mCallbacks.onSuccess();
                        } else {
                            mCallbacks.onFail(response.getMessage());
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
