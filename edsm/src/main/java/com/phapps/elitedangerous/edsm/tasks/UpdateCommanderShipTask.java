package com.phapps.elitedangerous.edsm.tasks;

import android.net.Uri;
import android.text.TextUtils;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.phapps.elitedangerous.edsm.EdsmClient;
import com.phapps.elitedangerous.edsm.callbacks.UpdateCommanderShipCallbacks;
import com.phapps.elitedangerous.edsm.dto.UpdateResultDto;
import com.phapps.elitedangerous.edsm.network.GsonRequest;
import com.phapps.elitedangerous.edsm.requests.UpdateCommanderShipRequest;

public class UpdateCommanderShipTask extends CommanderTask {
    private static final String COMMAND = "update-ship";
    private static final String PARAM_SHIP_ID = "shipId";
    private static final String PARAM_SHIP_NAME = "shipName";
    private static final String PARAM_SHIP_IDENT = "shipIdent";
    private static final String PARAM_TYPE = "type";
    private static final String PARAM_PAINT_JOB = "paintJob";
    private static final String PARAM_CARGO_QTY = "cargoQty";
    private static final String PARAM_CARGO_CAPACITY = "cargoCapacity";
    private static final String PARAM_FUEL_MAIN_CAPACITY = "fuelMainCapacity";
    private static final String PARAM_FUEL_MAIN_LEVEL = "fuelMainLevel";
    private static final String PARAM_FUEL_RESERVE_CAPACITY = "fuelReserveCapacity";
    private static final String PARAM_FUEL_RESERVE_LEVEL = "fuelReserveLevel";
    private static final String PARAM_LINK_TO_CORIOLLIS = "linkToCoriollis";
    private static final String PARAM_LINK_TO_ED_SHIPYARD = "linkToEDShipyard";

    private final UpdateCommanderShipRequest mRequest;
    private final UpdateCommanderShipCallbacks mCallbacks;

    public UpdateCommanderShipTask(RequestQueue requestQueue, EdsmClient.Server server,
            UpdateCommanderShipRequest request,
            UpdateCommanderShipCallbacks callbacks) {
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

        if (!TextUtils.isEmpty(mRequest.getShipName())) {
            builder.appendQueryParameter(PARAM_SHIP_NAME, mRequest.getShipName());
        }

        if (!TextUtils.isEmpty(mRequest.getShipIdent())) {
            builder.appendQueryParameter(PARAM_SHIP_IDENT, mRequest.getShipIdent());
        }

        if (!TextUtils.isEmpty(mRequest.getType())) {
            builder.appendQueryParameter(PARAM_TYPE, mRequest.getType());
        }

        if (!TextUtils.isEmpty(mRequest.getPaintJob())) {
            builder.appendQueryParameter(PARAM_PAINT_JOB, mRequest.getPaintJob());
        }

        if (!TextUtils.isEmpty(mRequest.getCargoQuantity())) {
            builder.appendQueryParameter(PARAM_CARGO_QTY, mRequest.getCargoQuantity());
        }

        if (!TextUtils.isEmpty(mRequest.getCargoCapacity())) {
            builder.appendQueryParameter(PARAM_CARGO_CAPACITY, mRequest.getCargoCapacity());
        }

        if (!TextUtils.isEmpty(mRequest.getFuelMainCapacity())) {
            builder.appendQueryParameter(PARAM_FUEL_MAIN_CAPACITY, mRequest.getFuelMainCapacity());
        }

        if (!TextUtils.isEmpty(mRequest.getFuelMainLevel())) {
            builder.appendQueryParameter(PARAM_FUEL_MAIN_LEVEL, mRequest.getFuelMainLevel());
        }

        if (!TextUtils.isEmpty(mRequest.getFuelReserveCapacity())) {
            builder.appendQueryParameter(PARAM_FUEL_RESERVE_CAPACITY, mRequest.getFuelReserveCapacity());
        }

        if (!TextUtils.isEmpty(mRequest.getFuelReserveLevel())) {
            builder.appendQueryParameter(PARAM_FUEL_RESERVE_LEVEL, mRequest.getFuelReserveLevel());
        }

        if (!TextUtils.isEmpty(mRequest.getLinkToCoriollis())) {
            builder.appendQueryParameter(PARAM_LINK_TO_CORIOLLIS, mRequest.getLinkToCoriollis());
        }

        if (!TextUtils.isEmpty(mRequest.getLinkToEdShipyard())) {
            builder.appendQueryParameter(PARAM_LINK_TO_ED_SHIPYARD, mRequest.getLinkToEdShipyard());
        }

        GsonRequest<UpdateResultDto> gsonRequest = new GsonRequest<>(
                builder.build().toString(),
                UpdateResultDto.class,
                getHeaders(),
                new Response.Listener<UpdateResultDto>() {
                    @Override
                    public void onResponse(UpdateResultDto response) {
                        if (response != null) {
                            if (response.getMessageNumber() == 100) {
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
