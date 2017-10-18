package com.phapps.elitedangerous.eddb.tasks;

import android.net.Uri;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.phapps.elitedangerous.eddb.EdsmClient;
import com.phapps.elitedangerous.eddb.callbacks.SetCommanderCurrentShipCallbacks;
import com.phapps.elitedangerous.eddb.dto.SetShipIdResultDto;
import com.phapps.elitedangerous.eddb.network.GsonRequest;
import com.phapps.elitedangerous.eddb.requests.SetCommanderCurrentShipRequest;

public class SetCommanderCurrentShipTask extends CommanderTask {

    private static final String COMMAND = "set-ship-id";
    private static final String PARAM_SHIP_ID = "shipId";

    private final SetCommanderCurrentShipRequest mRequest;
    private final SetCommanderCurrentShipCallbacks mCallbacks;

    public SetCommanderCurrentShipTask(RequestQueue requestQueue, EdsmClient.Server server,
            SetCommanderCurrentShipRequest request, SetCommanderCurrentShipCallbacks callbacks) {
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

        GsonRequest<SetShipIdResultDto> gsonRequest = new GsonRequest<>(
                builder.build().toString(),
                SetShipIdResultDto.class,
                getHeaders(),
                new Response.Listener<SetShipIdResultDto>() {
                    @Override
                    public void onResponse(SetShipIdResultDto response) {
                        if (response != null) {
                            if (response.getMessageNumber() != null &&
                                    response.getMessageNumber() == 100) {
                                mCallbacks.onSuccess(response.getInDatabase());
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
