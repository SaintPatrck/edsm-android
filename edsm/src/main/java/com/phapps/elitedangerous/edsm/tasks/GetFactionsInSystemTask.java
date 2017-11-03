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
