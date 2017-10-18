package com.phapps.elitedangerous.eddb;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.phapps.elitedangerous.eddb.callbacks.GetCommanderCreditsCallbacks;
import com.phapps.elitedangerous.eddb.callbacks.GetCommanderInventoryCallbacks;
import com.phapps.elitedangerous.eddb.callbacks.GetCommanderRanksCallbacks;
import com.phapps.elitedangerous.eddb.callbacks.GetServerStatusCallbacks;
import com.phapps.elitedangerous.eddb.callbacks.GetSystemInfoCallbacks;
import com.phapps.elitedangerous.eddb.callbacks.SellCommanderShipCallbacks;
import com.phapps.elitedangerous.eddb.callbacks.SetCommanderCreditsCallbacks;
import com.phapps.elitedangerous.eddb.callbacks.SetCommanderCurrentShipCallbacks;
import com.phapps.elitedangerous.eddb.callbacks.SetCommanderMaterialsCallbacks;
import com.phapps.elitedangerous.eddb.callbacks.SetCommanderRanksCallbacks;
import com.phapps.elitedangerous.eddb.callbacks.UpdateCommanderShipCallbacks;
import com.phapps.elitedangerous.eddb.dto.ServerStatusDto;
import com.phapps.elitedangerous.eddb.dto.SystemDto;
import com.phapps.elitedangerous.eddb.network.GsonRequest;
import com.phapps.elitedangerous.eddb.requests.BaseSystemRequest;
import com.phapps.elitedangerous.eddb.requests.GetCommanderCreditsRequest;
import com.phapps.elitedangerous.eddb.requests.GetCommanderInventoryRequest;
import com.phapps.elitedangerous.eddb.requests.GetSystemInfoRequest;
import com.phapps.elitedangerous.eddb.requests.GetSystemsInAreaRequest;
import com.phapps.elitedangerous.eddb.requests.PlanRouteRequest;
import com.phapps.elitedangerous.eddb.requests.SellCommanderShipRequest;
import com.phapps.elitedangerous.eddb.requests.SetCommanderCreditsRequest;
import com.phapps.elitedangerous.eddb.requests.SetCommanderCurrentShipRequest;
import com.phapps.elitedangerous.eddb.requests.SetCommanderInventoryRequest;
import com.phapps.elitedangerous.eddb.requests.SetCommanderRanksRequest;
import com.phapps.elitedangerous.eddb.requests.UpdateCommanderShipRequest;
import com.phapps.elitedangerous.eddb.tasks.GetCommanderCreditsTask;
import com.phapps.elitedangerous.eddb.tasks.GetCommanderInventoryTask;
import com.phapps.elitedangerous.eddb.tasks.GetCommanderRanksTask;
import com.phapps.elitedangerous.eddb.tasks.SellCommanderShipTask;
import com.phapps.elitedangerous.eddb.tasks.SetCommanderCreditsTask;
import com.phapps.elitedangerous.eddb.tasks.SetCommanderCurrentShipTask;
import com.phapps.elitedangerous.eddb.tasks.SetCommanderInventoryTask;
import com.phapps.elitedangerous.eddb.tasks.SetCommanderRanksTask;
import com.phapps.elitedangerous.eddb.tasks.UpdateCommanderShipTask;

import java.util.HashMap;
import java.util.Map;

/**
 * Class that provides access to the Elite: Dangerous Star Map APIs, and a few other functions
 * commonly used by players.
 * <p/>
 * Make sure to {@link #init(Context)} the API before calling any of the API methods.
 * <p/>
 * All methods return a {@link Response} object that can be used to cancel the request.
 */
// TODO: finish creating Tasks for API calls.
@SuppressWarnings("WeakerAccess")
@Keep
public class EdsmClient {

    private static final String TAG = EdsmClient.class.getName();

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

    //region Commander

    /**
     * Get rank and progress information for a Commander.
     * <br/>
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

        new GetCommanderRanksTask(mRequestQueue, mServer, commanderName, apiKey, callbacks).execute();
    }

    /**
     * Update rank in progress information for a Commander
     * <br/>
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

    public void setCommanderCredits(
            @NonNull SetCommanderCreditsRequest request,
            @NonNull final SetCommanderCreditsCallbacks callbacks) {
        verifyInitCalled();

        new SetCommanderCreditsTask(mRequestQueue, mServer, request, callbacks).execute();
    }

    public void setCommanderCurrentShipId(
            @NonNull SetCommanderCurrentShipRequest request,
            @NonNull final SetCommanderCurrentShipCallbacks callbacks) {
        verifyInitCalled();

        new SetCommanderCurrentShipTask(mRequestQueue, mServer, request, callbacks).execute();
    }

    public void updateCommanderShip(
            @NonNull UpdateCommanderShipRequest request,
            @NonNull final UpdateCommanderShipCallbacks callbacks) {
        verifyInitCalled();

        new UpdateCommanderShipTask(mRequestQueue, mServer, request, callbacks).execute();
    }

    public void sellCommanderShip(
            @NonNull SellCommanderShipRequest request,
            @NonNull final SellCommanderShipCallbacks callbacks) {
        verifyInitCalled();

        new SellCommanderShipTask(mRequestQueue, mServer, request, callbacks).execute();
    }

    public void getCommanderInventory(
            @NonNull GetCommanderInventoryRequest request,
            @NonNull final GetCommanderInventoryCallbacks callbacks) {
        verifyInitCalled();

        new GetCommanderInventoryTask(mRequestQueue, mServer, request, callbacks).execute();
    }

    public void setCommanderInventory(
            @NonNull SetCommanderInventoryRequest request,
            @NonNull final SetCommanderMaterialsCallbacks callbacks) {
        verifyInitCalled();

        new SetCommanderInventoryTask(mRequestQueue, mServer, request, callbacks).execute();
    }
    //endregion

    //region Systems

    /**
     * Queries for the details of a single Solar System
     *
     * @return Cancellable {@link Request} object.
     */
    public Request getSystemDetails(
            @NonNull GetSystemInfoRequest request,
            @NonNull final GetSystemInfoCallbacks callbacks) {
        verifyInitCalled();

        Uri.Builder builder = getUriBuilder("system", VERSION_1, "systems");
        for (String systemName : request.getSystemNames()) {
            builder.appendQueryParameter("systemName[]", systemName);
        }
        builder.appendQueryParameter("onlyFeatured", request.isOnlyFeatured() ? "1" : "0");
        builder.appendQueryParameter("onlyKnownCoordinates",
                request.isOnlyKnownCoords() ? "1" : "0");
        builder.appendQueryParameter("onlyUnknownCoordinates",
                request.isOnlyUnknownCoords() ? "1" : "0");

        if (request.getLastUpdatedStartDate() != null && request.getLastUpdatedEndDate() != null) {
            builder.appendQueryParameter("startDateTime",
                    Long.toString(request.getLastUpdatedStartDate().getTime()));
            builder.appendQueryParameter("endDateTime",
                    Long.toString(request.getLastUpdatedEndDate().getTime()));
        }

        setExpanderParams(builder, request);
        builder.appendQueryParameter("includeHidden", request.includeHidden() ? "1" : "0");

        GsonRequest<SystemDto[]> gsonRequest = new GsonRequest<>(
                builder.build().toString(),
                SystemDto[].class,
                getHeaders(),
                new Response.Listener<SystemDto[]>() {
                    @Override
                    public void onResponse(SystemDto[] response) {
                        // TODO: Handle response
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        callbacks.onError();
                    }
                });
        mRequestQueue.add(gsonRequest);

        return gsonRequest;
    }

    /**
     * Query all systems in a given area.
     */
    public Request getSystemsInArea(
            @NonNull GetSystemsInAreaRequest request,
            @NonNull Response.Listener<SystemDto[]> listener,
            @NonNull Response.ErrorListener errorListener) {
        verifyInitCalled();

        String api;
        if (request.getShape() == GetSystemsInAreaRequest.SHAPE_SPHERE) {
            api = "sphere-systems";
        } else if (request.getShape() == GetSystemsInAreaRequest.SHAPE_CUBE) {
            api = "cube-systems";
        } else {
            api = "";
        }

        Uri.Builder uriBuilder = getUriBuilder("system", VERSION_1, api);
        if (!TextUtils.isEmpty(request.getSystemName())) {
            uriBuilder.appendQueryParameter("systemName", request.getSystemName());
        } else if (request.getCoordinates() != null) {
            uriBuilder.appendQueryParameter("x", String.valueOf(request.getCoordinates().getX()));
            uriBuilder.appendQueryParameter("y", String.valueOf(request.getCoordinates().getY()));
            uriBuilder.appendQueryParameter("z", String.valueOf(request.getCoordinates().getZ()));
        }

        if (request.getShape() == GetSystemsInAreaRequest.SHAPE_CUBE) {
            uriBuilder.appendQueryParameter("size", String.valueOf(request.getSize()));
        } else if (request.getShape() == GetSystemsInAreaRequest.SHAPE_SPHERE) {
            uriBuilder.appendQueryParameter("minRadius", String.valueOf(request.getMinRadius()));
            uriBuilder.appendQueryParameter("radius", String.valueOf(request.getRadius()));
        }

        setExpanderParams(uriBuilder, request);

        GsonRequest<SystemDto[]> gsonRequest = new GsonRequest<>(uriBuilder.build().toString(),
                SystemDto[].class,
                getHeaders(),
                listener,
                errorListener);
        mRequestQueue.add(gsonRequest);

        return gsonRequest;
    }
    //endregion

    //region Route Planning

    /**
     * Calculates the most direct route between two systems.
     */
    public Request planRoute(
            @NonNull PlanRouteRequest planRouteRequest,
            @NonNull final Response.Listener<SystemDto[]> responseListener,
            @NonNull final Response.ErrorListener errorListener) {
        Uri.Builder builder = Uri.parse("https://www.edsm.net/").buildUpon()
                .appendPath("en").appendPath("map").appendPath("planner").appendPath("index")
                .appendPath("endSystem").appendPath(planRouteRequest.getEndSystem())
                .appendPath("startSystem").appendPath(planRouteRequest.getStartSystem())
                .appendPath("maxJumpRange")
                .appendPath(String.valueOf(planRouteRequest.getMaxJumpRange()));

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                builder.build().toString(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            int startIndex = response.indexOf("var currentRoute");
                            startIndex = response.indexOf("[", startIndex);
                            int endIndex = response.indexOf(";", startIndex);
                            String routeJson = response.substring(startIndex, endIndex);
                            responseListener
                                    .onResponse(new Gson().fromJson(routeJson, SystemDto[].class));
                        } catch (Exception e) {
                            errorListener.onErrorResponse(new ParseError());
                        }
                    }
                },
                errorListener);
        mRequestQueue.add(stringRequest);
        return stringRequest;
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
        return Uri.parse(mServer.address).buildUpon().appendPath("api-" + api + "-v" + version)
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
        Production("https://www.edsm.net"),
        Test("http://beta.edsm.net:8080");

        public final String address;

        Server(String address) {
            this.address = address;
        }
    }
}
