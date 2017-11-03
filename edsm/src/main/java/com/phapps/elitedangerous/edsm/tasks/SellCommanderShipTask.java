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
