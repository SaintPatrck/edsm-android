package com.phapps.elitedangerous.eddb.tasks;

import android.net.Uri;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.phapps.elitedangerous.eddb.EdsmClient;
import com.phapps.elitedangerous.eddb.callbacks.SetCommanderMaterialsCallbacks;
import com.phapps.elitedangerous.eddb.dto.SetCommanderValuesResultDto;
import com.phapps.elitedangerous.eddb.network.GsonRequest;
import com.phapps.elitedangerous.eddb.requests.SetCommanderInventoryRequest;

public class SetCommanderInventoryTask extends CommanderTask {

    private static final String COMMAND = "set-materials";
    private static final String PARAM_TYPE = "type";
    private static final String PARAM_VALUES = "values";

    private final SetCommanderInventoryRequest mRequest;
    private final SetCommanderMaterialsCallbacks mCallbacks;

    public SetCommanderInventoryTask(RequestQueue requestQueue, EdsmClient.Server server,
            SetCommanderInventoryRequest request, SetCommanderMaterialsCallbacks callbacks) {
        super(requestQueue, server, request.getCommanderName(), request.getApiKey());

        mRequest = request;
        mCallbacks = callbacks;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        Uri.Builder builder = getUriBuilder(VERSION_1, COMMAND);
        builder.appendQueryParameter(PARAM_COMMANDER_NAME, mRequest.getCommanderName())
                .appendQueryParameter(PARAM_API_KEY, mRequest.getApiKey())
                .appendQueryParameter(PARAM_TYPE, mRequest.getType());

        if (mRequest.getValues() != null && !mRequest.getValues().isEmpty()) {
            try {
                String valuesJson = new Gson().toJson(mRequest.getValues());
                if (valuesJson != null) {
                    builder.appendQueryParameter(PARAM_VALUES, valuesJson);
                }
            } catch (Exception e) {
                mCallbacks.onError();
            }
        }

        GsonRequest<SetCommanderValuesResultDto> gsonRequest = new GsonRequest<>(
                builder.build().toString(), SetCommanderValuesResultDto.class, getHeaders(),
                new Response.Listener<SetCommanderValuesResultDto>() {
                    @Override
                    public void onResponse(SetCommanderValuesResultDto response) {
                        if (response != null) {
                            if (response.getMessageNumber() != null &&
                                    response.getMessageNumber() == 100) {
                                mCallbacks.onSuccess(response.getMaterials());
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
