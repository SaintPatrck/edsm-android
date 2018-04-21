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
import android.support.annotation.NonNull;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.phapps.elitedangerous.edsm.EdsmClient;
import com.phapps.elitedangerous.edsm.callbacks.GetSystemInfoCallbacks;
import com.phapps.elitedangerous.edsm.dto.SystemDto;
import com.phapps.elitedangerous.edsm.network.GsonRequest;
import com.phapps.elitedangerous.edsm.requests.BaseSystemRequest;
import com.phapps.elitedangerous.edsm.requests.GetSystemInfoRequest;

public class GetSystemInfoTask extends EdsmTask {

    private final GetSystemInfoRequest mRequest;
    private final GetSystemInfoCallbacks mCallbacks;

    public GetSystemInfoTask(RequestQueue requestQueue, EdsmClient.Server server, GetSystemInfoRequest request,
            GetSystemInfoCallbacks callbacks) {
        super(requestQueue, server);
        mRequest = request;
        mCallbacks = callbacks;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        Uri.Builder builder = getUriBuilder(null, VERSION_1, "systems");

        if (mRequest.getSystemNames().size() == 1) {
            builder.appendQueryParameter("systemName", mRequest.getSystemNames().get(0));
        } else {
            for (String systemName : mRequest.getSystemNames()) {
                builder.appendQueryParameter("systemName[]", systemName);
            }
        }

        builder.appendQueryParameter("onlyFeatured", mRequest.isOnlyFeatured() ? "1" : "0");
        builder.appendQueryParameter("onlyKnownCoordinates",
                mRequest.isOnlyKnownCoords() ? "1" : "0");
        builder.appendQueryParameter("onlyUnknownCoordinates",
                mRequest.isOnlyUnknownCoords() ? "1" : "0");

        if (mRequest.getLastUpdatedStartDate() != null && mRequest.getLastUpdatedEndDate() != null) {
            builder.appendQueryParameter("startDateTime",
                    Long.toString(mRequest.getLastUpdatedStartDate().getTime()));
            builder.appendQueryParameter("endDateTime",
                    Long.toString(mRequest.getLastUpdatedEndDate().getTime()));
        }

        setExpanderParams(builder, mRequest);
        builder.appendQueryParameter("includeHidden", mRequest.includeHidden() ? "1" : "0");

        GsonRequest<SystemDto[]> gsonRequest = new GsonRequest<>(
                builder.build().toString(),
                SystemDto[].class,
                getHeaders(),
                new Response.Listener<SystemDto[]>() {
                    @Override
                    public void onResponse(SystemDto[] response) {
                        mCallbacks.onSuccess(response);
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

    private void setExpanderParams(@NonNull Uri.Builder builder,
            @NonNull BaseSystemRequest request) {
        builder.appendQueryParameter("showId", request.showId() ? "1" : "0");
        builder.appendQueryParameter("showCoordinates", request.showCoords() ? "1" : "0");
        builder.appendQueryParameter("showPermit", request.showPermit() ? "1" : "0");
        builder.appendQueryParameter("showInformation", request.showInformation() ? "1" : "0");
        builder.appendQueryParameter("showPrimaryStar", request.showPrimaryStar() ? "1" : "0");
    }
}
