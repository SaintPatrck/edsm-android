package com.phapps.elitedangerous.edsm.tasks;

import android.net.Uri;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.phapps.elitedangerous.edsm.EdsmClient;
import com.phapps.elitedangerous.edsm.callbacks.GetCelestialBodiesInSystemCallbacks;
import com.phapps.elitedangerous.edsm.dto.SystemBodiesDto;
import com.phapps.elitedangerous.edsm.network.GsonRequest;
import com.phapps.elitedangerous.edsm.requests.GetCelestialBodiesInSystemRequest;

public class GetCelestialBodiesInSystemTask extends EdsmTask {

    private final GetCelestialBodiesInSystemRequest mRequest;
    private final GetCelestialBodiesInSystemCallbacks mCallbacks;

    public GetCelestialBodiesInSystemTask(RequestQueue requestQueue, EdsmClient.Server server,
            GetCelestialBodiesInSystemRequest request, GetCelestialBodiesInSystemCallbacks callbacks) {
        super(requestQueue, server);
        mRequest = request;
        mCallbacks = callbacks;
    }

    @Override
    protected Void doInBackground(Void... voids) {

        Uri.Builder builder = getUriBuilder("system", VERSION_1, "bodies");
        builder.appendQueryParameter("systemName", mRequest.getSystemName());
        if (mRequest.getSystemId() != null) {
            builder.appendQueryParameter("systemId", String.valueOf(mRequest.getSystemId()));
        }

        GsonRequest<SystemBodiesDto> request = new GsonRequest<>(builder.build().toString(),
                SystemBodiesDto.class,
                getHeaders(),
                new Response.Listener<SystemBodiesDto>() {
                    @Override
                    public void onResponse(SystemBodiesDto response) {
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
