/*
 * Copyright (c) 2017.
 *
 * Copyright 2017 Patrick Honkonen
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.phapps.elitedangerous.edsm;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.phapps.elitedangerous.edsm.callbacks.GetCelestialBodiesInSystemCallbacks;
import com.phapps.elitedangerous.edsm.callbacks.GetCommanderCreditsCallbacks;
import com.phapps.elitedangerous.edsm.callbacks.GetCommanderInventoryCallbacks;
import com.phapps.elitedangerous.edsm.callbacks.GetCommanderRanksCallbacks;
import com.phapps.elitedangerous.edsm.callbacks.GetFactionsInSystemCallbacks;
import com.phapps.elitedangerous.edsm.callbacks.GetServerStatusCallbacks;
import com.phapps.elitedangerous.edsm.callbacks.GetStationsInSystemCallbacks;
import com.phapps.elitedangerous.edsm.callbacks.GetSystemInfoCallbacks;
import com.phapps.elitedangerous.edsm.callbacks.GetSystemsInAreaCallbacks;
import com.phapps.elitedangerous.edsm.callbacks.PlanRouteCallbacks;
import com.phapps.elitedangerous.edsm.callbacks.SellCommanderShipCallbacks;
import com.phapps.elitedangerous.edsm.callbacks.SetCommanderCreditsCallbacks;
import com.phapps.elitedangerous.edsm.callbacks.SetCommanderCurrentShipCallbacks;
import com.phapps.elitedangerous.edsm.callbacks.SetCommanderMaterialsCallbacks;
import com.phapps.elitedangerous.edsm.callbacks.SetCommanderRanksCallbacks;
import com.phapps.elitedangerous.edsm.callbacks.UpdateCommanderShipCallbacks;
import com.phapps.elitedangerous.edsm.dto.ServerStatusDto;
import com.phapps.elitedangerous.edsm.network.GsonRequest;
import com.phapps.elitedangerous.edsm.requests.BaseSystemRequest;
import com.phapps.elitedangerous.edsm.requests.GetCelestialBodiesInSystemRequest;
import com.phapps.elitedangerous.edsm.requests.GetCommanderCreditsRequest;
import com.phapps.elitedangerous.edsm.requests.GetCommanderInventoryRequest;
import com.phapps.elitedangerous.edsm.requests.GetFactionsInSystemRequest;
import com.phapps.elitedangerous.edsm.requests.GetStationsInSystemRequest;
import com.phapps.elitedangerous.edsm.requests.GetSystemInfoRequest;
import com.phapps.elitedangerous.edsm.requests.GetSystemsInAreaRequest;
import com.phapps.elitedangerous.edsm.requests.PlanRouteRequest;
import com.phapps.elitedangerous.edsm.requests.SellCommanderShipRequest;
import com.phapps.elitedangerous.edsm.requests.SetCommanderCreditsRequest;
import com.phapps.elitedangerous.edsm.requests.SetCommanderCurrentShipRequest;
import com.phapps.elitedangerous.edsm.requests.SetCommanderInventoryRequest;
import com.phapps.elitedangerous.edsm.requests.SetCommanderRanksRequest;
import com.phapps.elitedangerous.edsm.requests.UpdateCommanderShipRequest;
import com.phapps.elitedangerous.edsm.tasks.GetCelestialBodiesInSystemTask;
import com.phapps.elitedangerous.edsm.tasks.GetCommanderCreditsTask;
import com.phapps.elitedangerous.edsm.tasks.GetCommanderInventoryTask;
import com.phapps.elitedangerous.edsm.tasks.GetCommanderRanksTask;
import com.phapps.elitedangerous.edsm.tasks.GetFactionsInSystemTask;
import com.phapps.elitedangerous.edsm.tasks.GetStationsInSystemTask;
import com.phapps.elitedangerous.edsm.tasks.GetSystemInfoTask;
import com.phapps.elitedangerous.edsm.tasks.GetSystemsInAreaTask;
import com.phapps.elitedangerous.edsm.tasks.PlanRouteTask;
import com.phapps.elitedangerous.edsm.tasks.SellCommanderShipTask;
import com.phapps.elitedangerous.edsm.tasks.SetCommanderCreditsTask;
import com.phapps.elitedangerous.edsm.tasks.SetCommanderCurrentShipTask;
import com.phapps.elitedangerous.edsm.tasks.SetCommanderInventoryTask;
import com.phapps.elitedangerous.edsm.tasks.SetCommanderRanksTask;
import com.phapps.elitedangerous.edsm.tasks.UpdateCommanderShipTask;
import com.phapps.elitedangerous.edsm.utils.LogHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * Class that provides access to the Elite: Dangerous Star Map APIs, and a few other functions
 * commonly used by players.
 * <p>
 * Make sure to {@link #init(Context)} the API before calling any of the API methods.
 */
@SuppressWarnings("WeakerAccess")
@Keep
public class EdsmClient {

    private static final int VERSION_1 = 1;
    private static final String API_STATUS = "status";

    private static EdsmClient sInstance;

    private Server mServer;
    private RequestQueue mRequestQueue;

    private EdsmClient(Context context) {
        //no instance
        mServer = Server.Test;
        mRequestQueue = Volley.newRequestQueue(context.getApplicationContext());
    }

    /**
     * Initializes the API for use.
     * <p>
     * Must be called before any other API methods are called.
     *
     * @param context in which the API will be used. Application context is used regardless of the
     * type of context
     * provided.
     */
    public static void init(Context context) {
        sInstance = new EdsmClient(context);
    }

    /**
     * @return Singleton instance of {@code this} client.
     */
    public static EdsmClient getInstance() {
        return sInstance;
    }

    /**
     * Override the default mServer environment.
     * <p>
     * By default {@link Server#Test} is used.
     *
     * @param server {@link Server} environment to use during this session.
     */
    public void setServer(@NonNull Server server) {
        mServer = server;
    }

    /**
     * Get the Elite: Dangerous server status.
     */
    public void getServerStatus(@NonNull final GetServerStatusCallbacks callbacks) {
        verifyInitCalled();

        Uri.Builder builder = getUriBuilder(API_STATUS, VERSION_1, "elite-server");

        GsonRequest<ServerStatusDto> gsonRequest = new GsonRequest<>(
                builder.build().toString(),
                ServerStatusDto.class,
                getHeaders(),
                new Response.Listener<ServerStatusDto>() {
                    @Override
                    public void onResponse(ServerStatusDto response) {
                        callbacks.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        callbacks.onError();
                    }
                });
        mRequestQueue.add(gsonRequest);
    }

    public void setLoggingEnabled(boolean enabled) {
        LogHelper.setEnabled(enabled);
    }

    //region Commander

    /**
     * Get rank and progress information for a Commander.
     * <p>
     * Commander <b>must</b> be registered with EDSM
     *
     * @param commanderName The name of the commander as registered on EDSM.
     * @param apiKey The API Key associated with the {@code commanderName}. If not provided, ranks
     * will only be returned if the commander has enabled his public profile.
     */
    public void getCommanderRanks(
            @NonNull final String commanderName,
            @Nullable String apiKey,
            @NonNull final GetCommanderRanksCallbacks callbacks) {
        verifyInitCalled();

        new GetCommanderRanksTask(mRequestQueue, mServer, commanderName, apiKey, callbacks)
                .execute();
    }

    /**
     * Update rank in progress information for a Commander
     * <p>
     * Commander <b>must</b> be registered with EDSM
     */
    public void setCommanderRanks(
            @NonNull SetCommanderRanksRequest request,
            @NonNull final SetCommanderRanksCallbacks callbacks) {
        verifyInitCalled();

        new SetCommanderRanksTask(mRequestQueue, mServer, request, callbacks).execute();
    }

    /**
     * @param request
     * @param callbacks
     */
    public void getCommanderCredits(
            @NonNull GetCommanderCreditsRequest request,
            @NonNull final GetCommanderCreditsCallbacks callbacks) {
        verifyInitCalled();

        new GetCommanderCreditsTask(mRequestQueue, mServer, request, callbacks).execute();
    }

    /**
     * @param request
     * @param callbacks
     */
    public void setCommanderCredits(
            @NonNull SetCommanderCreditsRequest request,
            @NonNull final SetCommanderCreditsCallbacks callbacks) {
        verifyInitCalled();

        new SetCommanderCreditsTask(mRequestQueue, mServer, request, callbacks).execute();
    }

    /**
     * @param request
     * @param callbacks
     */
    public void setCommanderCurrentShipId(
            @NonNull SetCommanderCurrentShipRequest request,
            @NonNull final SetCommanderCurrentShipCallbacks callbacks) {
        verifyInitCalled();

        new SetCommanderCurrentShipTask(mRequestQueue, mServer, request, callbacks).execute();
    }

    /**
     * @param request
     * @param callbacks
     */
    public void updateCommanderShip(
            @NonNull UpdateCommanderShipRequest request,
            @NonNull final UpdateCommanderShipCallbacks callbacks) {
        verifyInitCalled();

        new UpdateCommanderShipTask(mRequestQueue, mServer, request, callbacks).execute();
    }

    /**
     * @param request
     * @param callbacks
     */
    public void sellCommanderShip(
            @NonNull SellCommanderShipRequest request,
            @NonNull final SellCommanderShipCallbacks callbacks) {
        verifyInitCalled();

        new SellCommanderShipTask(mRequestQueue, mServer, request, callbacks).execute();
    }

    /**
     * @param request
     * @param callbacks
     */
    public void getCommanderInventory(
            @NonNull GetCommanderInventoryRequest request,
            @NonNull final GetCommanderInventoryCallbacks callbacks) {
        verifyInitCalled();

        new GetCommanderInventoryTask(mRequestQueue, mServer, request, callbacks).execute();
    }

    /**
     * @param request
     * @param callbacks
     */
    public void setCommanderInventory(
            @NonNull SetCommanderInventoryRequest request,
            @NonNull final SetCommanderMaterialsCallbacks callbacks) {
        verifyInitCalled();

        new SetCommanderInventoryTask(mRequestQueue, mServer, request, callbacks).execute();
    }
    //endregion

    //region Systems

    /**
     * Queries for the details of a single Solar System.
     *
     * @param request
     * @param callbacks
     */
    public void getSystemDetails(
            @NonNull GetSystemInfoRequest request,
            @NonNull GetSystemInfoCallbacks callbacks) {
        verifyInitCalled();

        new GetSystemInfoTask(mRequestQueue, mServer, request, callbacks).execute();
    }

    /**
     * Query all systems in a given area.
     *
     * @param request
     * @param callbacks
     */
    public void getSystemsInArea(
            @NonNull GetSystemsInAreaRequest request,
            @NonNull GetSystemsInAreaCallbacks callbacks) {
        verifyInitCalled();

        new GetSystemsInAreaTask(mRequestQueue, mServer, request, callbacks).execute();
    }

    /**
     * @param request
     * @param callbacks
     */
    public void getCelestialBodiesInSystem(
            @NonNull GetCelestialBodiesInSystemRequest request,
            @NonNull GetCelestialBodiesInSystemCallbacks callbacks) {
        verifyInitCalled();

        new GetCelestialBodiesInSystemTask(mRequestQueue, mServer, request, callbacks).execute();
    }

    /**
     * @param request
     * @param callbacks
     */
    public void getStationsInSystem(
            @NonNull GetStationsInSystemRequest request,
            @NonNull GetStationsInSystemCallbacks callbacks) {
        verifyInitCalled();

        new GetStationsInSystemTask(mRequestQueue, mServer, request, callbacks).execute();
    }

    /**
     * @param request
     * @param callbacks
     */
    public void getFactionsInSystem(
            @NonNull GetFactionsInSystemRequest request,
            @NonNull GetFactionsInSystemCallbacks callbacks) {
        verifyInitCalled();

        new GetFactionsInSystemTask(mRequestQueue, mServer, request, callbacks).execute();
    }
    //endregion

    //region Route Planning

    /**
     * Calculates the most direct route between two systems.
     *
     * @param planRouteRequest request parameters to use when planning route.
     * @param callbacks {@link PlanRouteCallbacks} that will receive the response
     */
    public void planRoute(
            @NonNull PlanRouteRequest planRouteRequest,
            @NonNull PlanRouteCallbacks callbacks) {
        verifyInitCalled();

        new PlanRouteTask(mRequestQueue, mServer, planRouteRequest, callbacks).execute();
    }
    //endregion

    //region Helpers

    /**
     * Verifies that {@link #init(Context)} was called. Should be the first call within any API
     * method.
     *
     * @throws IllegalStateException if {@link #init(Context)} was not called prior to any other
     * methods.
     */
    private void verifyInitCalled() {
        if (mRequestQueue == null) {
            throw new IllegalStateException("Init must be called before any other methods.");
        }
    }

    @NonNull
    private Uri.Builder getUriBuilder(String api, int version, String command) {
        String apiPath;
        if (api != null) {
            apiPath = "-" + api;
        } else {
            apiPath = "";
        }
        return Uri.parse(mServer.address).buildUpon().appendPath("api" + apiPath + "-v" + version)
                .appendPath(command);
    }

    private Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept-Encoding", "gzip");
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        return headers;
    }

    private void setExpanderParams(@NonNull Uri.Builder builder,
            @NonNull BaseSystemRequest request) {
        builder.appendQueryParameter("showId", request.showId() ? "1" : "0");
        builder.appendQueryParameter("showCoordinates", request.showCoords() ? "1" : "0");
        builder.appendQueryParameter("showPermit", request.showPermit() ? "1" : "0");
        builder.appendQueryParameter("showInformation", request.showInformation() ? "1" : "0");
        builder.appendQueryParameter("showPrimaryStar", request.showPrimaryStar() ? "1" : "0");
    }
    //endregion

    public enum Server {

        /**
         * Production endpoint with real-time data access.
         */
        Production("https://www.edsm.net"),

        /**
         * Suggested endpoint for development and testing.
         * <p>
         * Data should mirror production data for the most part.
         */
        Test("http://beta.edsm.net:8080");

        public final String address;

        Server(String address) {
            this.address = address;
        }
    }
}
