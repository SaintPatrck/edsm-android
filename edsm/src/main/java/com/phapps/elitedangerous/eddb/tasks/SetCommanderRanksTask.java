package com.phapps.elitedangerous.eddb.tasks;

import android.net.Uri;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.phapps.elitedangerous.eddb.EdsmClient;
import com.phapps.elitedangerous.eddb.callbacks.SetCommanderRanksCallbacks;
import com.phapps.elitedangerous.eddb.dto.UpdateResultDto;
import com.phapps.elitedangerous.eddb.network.GsonRequest;
import com.phapps.elitedangerous.eddb.requests.SetCommanderRanksRequest;

public class SetCommanderRanksTask extends CommanderTask {

    private static final String COMMAND = "set-ranks";
    private static final String PARAM_COMBAT = "Combat";
    private static final String PARAM_TRADE = "Trade";
    private static final String PARAM_EXPLORE = "Explore";
    private static final String PARAM_CQC = "CQC";
    private static final String PARAM_FEDERATION = "Federation";
    private static final String PARAM_EMPIRE = "Empire";

    private SetCommanderRanksRequest mSetCommanderRanksRequest;
    private SetCommanderRanksCallbacks mCallbacks;

    public SetCommanderRanksTask(RequestQueue requestQueue, EdsmClient.Server server,
            SetCommanderRanksRequest request, SetCommanderRanksCallbacks callbacks) {
        super(requestQueue, server, request.getCommanderName(), request.getApiKey());
        mSetCommanderRanksRequest = request;
        mCallbacks = callbacks;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        Uri.Builder builder = getUriBuilder(VERSION_1, COMMAND);
        builder.appendQueryParameter(PARAM_COMMANDER_NAME, mSetCommanderRanksRequest.getCommanderName());
        builder.appendQueryParameter(PARAM_API_KEY, mSetCommanderRanksRequest.getApiKey());
        if (mSetCommanderRanksRequest.getCombatRank() != null) {
            String value = String.valueOf(mSetCommanderRanksRequest.getCombatRank());
            if (mSetCommanderRanksRequest.getCombatProgress() != null) {
                value += ";" + mSetCommanderRanksRequest.getCombatProgress();
            }
            builder.appendQueryParameter(PARAM_COMBAT, value);
        }

        if (mSetCommanderRanksRequest.getTradeRank() != null) {
            String value = String.valueOf(mSetCommanderRanksRequest.getTradeRank());
            if (mSetCommanderRanksRequest.getTradeProgress() != null) {
                value += ";" + mSetCommanderRanksRequest.getTradeProgress();
            }
            builder.appendQueryParameter(PARAM_TRADE, value);
        }

        if (mSetCommanderRanksRequest.getExploreRank() != null) {
            String value = String.valueOf(mSetCommanderRanksRequest.getExploreRank());
            if (mSetCommanderRanksRequest.getExploreProgress() != null) {
                value += ";" + mSetCommanderRanksRequest.getExploreProgress();
            }
            builder.appendQueryParameter(PARAM_EXPLORE, value);
        }

        if (mSetCommanderRanksRequest.getCqcRank() != null) {
            String value = String.valueOf(mSetCommanderRanksRequest.getCqcRank());
            if (mSetCommanderRanksRequest.getCqcProgress() != null) {
                value += ";" + mSetCommanderRanksRequest.getCqcProgress();
            }
            builder.appendQueryParameter(PARAM_CQC, value);
        }

        if (mSetCommanderRanksRequest.getFederationRank() != null) {
            String value = String.valueOf(mSetCommanderRanksRequest.getFederationRank());
            if (mSetCommanderRanksRequest.getFederationProgress() != null) {
                value += ";" + mSetCommanderRanksRequest.getFederationProgress();
            }
            builder.appendQueryParameter(PARAM_FEDERATION, value);
        }

        if (mSetCommanderRanksRequest.getEmpireRank() != null) {
            String value = String.valueOf(mSetCommanderRanksRequest.getEmpireRank());
            if (mSetCommanderRanksRequest.getEmpireProgress() != null) {
                value += ";" + mSetCommanderRanksRequest.getEmpireProgress();
            }
            builder.appendQueryParameter(PARAM_EMPIRE, value);
        }

        GsonRequest<UpdateResultDto> gsonRequest = new GsonRequest<>(builder.build().toString(),
                UpdateResultDto.class,
                getHeaders(),
                new Response.Listener<UpdateResultDto>() {
                    @Override
                    public void onResponse(UpdateResultDto response) {
                        if (response.getMessageNumber() != null &&
                                response.getMessageNumber() == 100) {
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
