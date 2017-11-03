package com.phapps.elitedangerous.edsm.tasks;

import android.net.Uri;
import android.text.TextUtils;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.phapps.elitedangerous.edsm.EdsmClient;
import com.phapps.elitedangerous.edsm.callbacks.GetCommanderRanksCallbacks;
import com.phapps.elitedangerous.edsm.dto.CommanderDto;
import com.phapps.elitedangerous.edsm.network.GsonRequest;

public class GetCommanderRanksTask extends CommanderTask {

    private static final String COMMAND = "get-ranks";
    private static final String PARAM_COMMANDER_NAME = "commanderName";
    private static final String PARAM_API_KEY = "apiKey";

    private GetCommanderRanksCallbacks mCallbacks;

    public GetCommanderRanksTask(RequestQueue requestQueue, EdsmClient.Server server, String commanderName,
            String apiKey, GetCommanderRanksCallbacks callbacks) {
        super(requestQueue, server, commanderName, apiKey);
        mCallbacks = callbacks;
    }

    @Override
    protected Void doInBackground(Void... voids) {

        Uri.Builder builder = getUriBuilder(VERSION_1, COMMAND);
        builder.appendQueryParameter(PARAM_COMMANDER_NAME, mCommanderName);
        if (!TextUtils.isEmpty(mApiKey)) {
            builder.appendQueryParameter(PARAM_API_KEY, mApiKey);
        }

        GsonRequest<CommanderDto> gsonRequest = new GsonRequest<>(
                builder.build().toString(),
                CommanderDto.class,
                getHeaders(),
                new Response.Listener<CommanderDto>() {
                    @Override
                    public void onResponse(CommanderDto commanderDto) {
                        if (commanderDto.getMessageNumber() == 100) {
                            mCallbacks.onSuccess(commanderDto);
                        } else {
                            mCallbacks.onFail(commanderDto.getMessage());
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
