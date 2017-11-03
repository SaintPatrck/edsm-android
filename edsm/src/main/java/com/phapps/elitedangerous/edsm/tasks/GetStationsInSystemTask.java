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
