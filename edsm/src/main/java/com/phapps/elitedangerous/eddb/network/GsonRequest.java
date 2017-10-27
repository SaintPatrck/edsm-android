package com.phapps.elitedangerous.eddb.network;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public class GsonRequest<T> extends Request<T> {

    private static final String TAG = "GsonRequest";

    private static final String EDSM_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private final Type mType;
    private final Map<String, String> mHeaders;
    private final Response.Listener<T> mListener;
    private Gson mGson;

    /**
     * Make a GET request and return a parsed object from JSON.
     *
     * @param url URL of the request to make
     * @param type Relevant class object, for Gson's reflection
     * @param headers Map of request headers
     */
    public GsonRequest(String url, Type type, Map<String, String> headers,
            Response.Listener<T> listener, Response.ErrorListener errorListener) {
        super(Method.GET, url, errorListener);
        mType = type;
        mHeaders = headers;
        mListener = listener;
        initGson();
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return mHeaders != null ? mHeaders : super.getHeaders();
    }

    @Override
    protected void deliverResponse(T response) {
        mListener.onResponse(response);
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            Log.d(TAG, "parseNetworkResponse() called with: response = [" + response + "]");
            String json;
            if (response.headers.containsKey("Content-Encoding") &&
                    response.headers.get("Content-Encoding").equals("gzip")) {
                json = decompressGzipData(response.data);
            } else {
                json = new String(response.data);
            }
            Log.d(TAG, json);
            T parseObject = mGson.fromJson(json, mType);
            return Response.success(parseObject, HttpHeaderParser.parseCacheHeaders(response));
        } catch (JsonSyntaxException e) {
            return Response.error(new ParseError(e));
        } catch (IOException e) {
            return Response.error(new ParseError(e));
        }
    }

    private String decompressGzipData(byte[] gzipData) throws IOException {
        final int BUFFER_SIZE = 32;
        ByteArrayInputStream is = new ByteArrayInputStream(gzipData);
        GZIPInputStream gis = new GZIPInputStream(is, BUFFER_SIZE);
        StringBuilder string = new StringBuilder();
        byte[] data = new byte[BUFFER_SIZE];
        int bytesRead;
        while ((bytesRead = gis.read(data)) != -1) {
            string.append(new String(data, 0, bytesRead));
        }
        gis.close();
        is.close();
        return string.toString();
    }

    private void initGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat(EDSM_DATE_FORMAT);
        mGson = gsonBuilder.create();
    }
}
