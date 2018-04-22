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
import com.phapps.elitedangerous.edsm.callbacks.SellCommanderShipCallbacks;
import com.phapps.elitedangerous.edsm.dto.UpdateResultDto;
import com.phapps.elitedangerous.edsm.network.GsonRequest;
import com.phapps.elitedangerous.edsm.requests.SellCommanderShipRequest;

public class SellCommanderShipTask extends CommanderTask {

    private static final String PARAM_SHIP_ID = "shipId";
    private static final String COMMAND = "sell-ship";

    private final SellCommanderShipRequest mRequest;
    private final SellCommanderShipCallbacks mCallbacks;

    public SellCommanderShipTask(RequestQueue requestQueue, EdsmClient.Server server, SellCommanderShipRequest request,
            SellCommanderShipCallbacks callbacks) {
        super(requestQueue, server, request.getCommanderName(), request.getApiKey());

        mRequest = request;
        mCallbacks = callbacks;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        Uri.Builder builder = getUriBuilder(VERSION_1, COMMAND);
        builder.appendQueryParameter(PARAM_COMMANDER_NAME, mRequest.getCommanderName())
                .appendQueryParameter(PARAM_API_KEY, mRequest.getApiKey())
                .appendQueryParameter(PARAM_SHIP_ID, String.valueOf(mRequest.getShipId()));

        GsonRequest<UpdateResultDto> gsonRequest = new GsonRequest<>(
                builder.build().toString(),
                UpdateResultDto.class,
                getHeaders(),
                new Response.Listener<UpdateResultDto>() {
                    @Override
                    public void onResponse(UpdateResultDto response) {
                        if (response != null) {
                            if (response.getMessageNumber() != null &&
                                    response.getMessageNumber() == 100) {
                                mCallbacks.onSuccess();
                            } else {
                                mCallbacks.onFail(response.getMessage());
                            }
                        } else {
                            mCallbacks.onError();
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
