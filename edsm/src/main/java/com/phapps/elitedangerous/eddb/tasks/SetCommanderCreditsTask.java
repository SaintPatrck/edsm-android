package com.phapps.elitedangerous.eddb.tasks;

import android.net.Uri;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.phapps.elitedangerous.eddb.EdsmClient;
import com.phapps.elitedangerous.eddb.callbacks.SetCommanderCreditsCallbacks;
import com.phapps.elitedangerous.eddb.dto.UpdateResultDto;
import com.phapps.elitedangerous.eddb.network.GsonRequest;
import com.phapps.elitedangerous.eddb.requests.SetCommanderCreditsRequest;

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
