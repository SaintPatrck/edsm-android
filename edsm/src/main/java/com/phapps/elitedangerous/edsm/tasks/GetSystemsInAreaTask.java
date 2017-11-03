package com.phapps.elitedangerous.edsm.tasks;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.phapps.elitedangerous.edsm.EdsmClient;
import com.phapps.elitedangerous.edsm.callbacks.GetSystemsInAreaCallbacks;
import com.phapps.elitedangerous.edsm.dto.SystemDistanceDto;
import com.phapps.elitedangerous.edsm.network.GsonRequest;
import com.phapps.elitedangerous.edsm.requests.BaseSystemRequest;
import com.phapps.elitedangerous.edsm.requests.GetSystemsInAreaRequest;

public class GetSystemsInAreaTask extends EdsmTask {
    private final GetSystemsInAreaRequest mRequest;
    private final GetSystemsInAreaCallbacks mCallbacks;

    public GetSystemsInAreaTask(RequestQueue requestQueue, EdsmClient.Server server, GetSystemsInAreaRequest request,
            GetSystemsInAreaCallbacks callbacks) {
        super(requestQueue, server);
        mRequest = request;
        mCallbacks = callbacks;
    }

    @Override
    protected Void doInBackground(Void... voids) {

        String api;
        if (mRequest.getShape() == GetSystemsInAreaRequest.SHAPE_SPHERE) {
            api = "sphere-systems";
        } else if (mRequest.getShape() == GetSystemsInAreaRequest.SHAPE_CUBE) {
            api = "cube-systems";
        } else {
            // Default to SHAPE_SPHERE if an unknown value is received.
            api = "sphere-systems";
        }

        Uri.Builder uriBuilder = getUriBuilder(null, VERSION_1, api);
        if (!TextUtils.isEmpty(mRequest.getSystemName())) {
            uriBuilder.appendQueryParameter("systemName", mRequest.getSystemName());
        } else if (mRequest.getCoordinates() != null) {
            uriBuilder.appendQueryParameter("x", String.valueOf(mRequest.getCoordinates().getX()));
            uriBuilder.appendQueryParameter("y", String.valueOf(mRequest.getCoordinates().getY()));
            uriBuilder.appendQueryParameter("z", String.valueOf(mRequest.getCoordinates().getZ()));
        }

        if (mRequest.getShape() == GetSystemsInAreaRequest.SHAPE_CUBE) {
            uriBuilder.appendQueryParameter("size", String.valueOf(mRequest.getSize()));
        } else if (mRequest.getShape() == GetSystemsInAreaRequest.SHAPE_SPHERE) {
            uriBuilder.appendQueryParameter("minRadius", String.valueOf(mRequest.getMinRadius()));
            uriBuilder.appendQueryParameter("radius", String.valueOf(mRequest.getRadius()));
        }

        setExpanderParams(uriBuilder, mRequest);

        GsonRequest<SystemDistanceDto[]> gsonRequest = new GsonRequest<>(uriBuilder.build().toString(),
                SystemDistanceDto[].class,
                getHeaders(),
                new Response.Listener<SystemDistanceDto[]>() {
                    @Override
                    public void onResponse(SystemDistanceDto[] response) {
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
