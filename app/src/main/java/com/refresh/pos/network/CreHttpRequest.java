package com.refresh.pos.network;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.error.AuthFailureError;
import com.android.volley.error.NetworkError;
import com.android.volley.error.NoConnectionError;
import com.android.volley.error.ParseError;
import com.android.volley.error.ServerError;
import com.android.volley.error.TimeoutError;
import com.android.volley.error.VolleyError;
import com.android.volley.request.SimpleMultiPartRequest;
import com.android.volley.request.StringRequest;
import com.android.volley.toolbox.Volley;
import com.refresh.pos.R;

import com.refresh.pos.config.Global;
import com.refresh.pos.ui.CreAbsActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CreHttpRequest {

    public static Context _context;
    protected static String _tag = CreHttpRequest.class.getSimpleName();

    public static int doHttpPost(final String url, final HashMap<String, String> map, final CreAbsActivity ctx) {

        Log.d(_tag, "*****HttpRequest: " + map.toString());
        final String command = map.get("method");
        if (!TextUtils.isEmpty(command)) {
            Global._lastCmd = command;
        }

        StringRequest postRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Global._waitingRes = false;
                Log.e(_tag, "*****params *["+url+"]* : " + map.toString());
                Log.e(_tag, "*****HttpResonse *["+url+"]* : " + response);
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    String status = jsonResponse.getString("status");
                    String msg = jsonResponse.getString("msg");
                    Global._lastMsg = msg;
                    if (status.equals("success")) {
                        ctx.onRequestSuccess(command, msg);
                    } else {
                        ctx.onRequestFail(command, msg);
                    }
                } catch (JSONException e) {
                    ctx.onRequestFail(command,"Error: Invalid response\n" + response);
                    e.printStackTrace();
                }
                ctx.showProgress(false);
            }
        }
        , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Global._waitingRes = false;
                volleyError.printStackTrace();
                ctx.showProgress(false);

                String message = "";
                if (volleyError instanceof NetworkError) {
                    message = _context.getString(R.string.error_internet);
                } else if (volleyError instanceof ServerError) {
                    message = _context.getString(R.string.error_server);
                } else if (volleyError instanceof AuthFailureError) {
                    message = _context.getString(R.string.error_internet);
                } else if (volleyError instanceof ParseError) {
                    message = _context.getString(R.string.error_parsing_response);
                } else if (volleyError instanceof NoConnectionError) {
                    message = _context.getString(R.string.error_internet);
                } else if (volleyError instanceof TimeoutError) {
                    message = _context.getString(R.string.error_timeout);
                } else {
                    message = _context.getString(R.string.error_something);
                }
                ctx.onRequestFail(command, message);
            }
        }) {
            protected Map<String, String> getParams() {
                return map;
            }


        };

        Global._waitingRes = true;
        if (ctx != null) {
            ctx.showProgress(true);
        }

        postRequest.setRetryPolicy(new DefaultRetryPolicy(3000, 2, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        Volley.newRequestQueue(_context).add(postRequest);

        return 0;
    }

    public static int doHttpPostWithFiles(final String url, final HashMap<String, String> stringParams,
                                          final HashMap<String, String> fileParams, final CreAbsActivity ctx) {

        Log.d(_tag, "*****HttpRequestWithFiles: " + stringParams.toString() + " ;; " + fileParams.toString());
        final String command = stringParams.get("method");
        if (!TextUtils.isEmpty(command)) {
            Global._lastCmd = command;
        }

        SimpleMultiPartRequest postRequest = new SimpleMultiPartRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Global._waitingRes = false;
                Log.e(_tag, "*****params *["+url+"]* : " + response);

                Log.e(_tag, "*****HttpResonse *["+url+"]* : " + response);
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    String status = jsonResponse.getString("status");
                    String msg = jsonResponse.getString("msg");
                    Global._lastMsg = msg;
                    if (status.equals("success")) {
                        ctx.onRequestSuccess(command, msg);
                    } else {
                        ctx.onRequestFail(command, msg);
                    }
                } catch (JSONException e) {
                    ctx.onRequestFail(command,"Error: Invalid response\n" + response);
                    e.printStackTrace();
                }
                ctx.showProgress(false);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Global._waitingRes = false;
                volleyError.printStackTrace();
                ctx.showProgress(false);

                String message = "";
                if (volleyError instanceof NetworkError) {
                    message = _context.getString(R.string.error_internet);
                } else if (volleyError instanceof ServerError) {
                    message = _context.getString(R.string.error_server);
                } else if (volleyError instanceof AuthFailureError) {
                    message = _context.getString(R.string.error_internet);
                } else if (volleyError instanceof ParseError) {
                    message = _context.getString(R.string.error_parsing_response);
                } else if (volleyError instanceof NoConnectionError) {
                    message = _context.getString(R.string.error_internet);
                } else if (volleyError instanceof TimeoutError) {
                    message = _context.getString(R.string.error_timeout);
                } else {
                    message = _context.getString(R.string.error_something);
                }
                ctx.onRequestFail(command, message);
            }
        });

        for (String key : stringParams.keySet()) {
            postRequest.addStringParam(key, stringParams.get(key));
        }
        for (String key : fileParams.keySet()) {
            postRequest.addFile(key, fileParams.get(key));
        }

        Global._waitingRes = true;
        if (ctx != null) {
            ctx.showProgress(true);
        }

        postRequest.setRetryPolicy(new DefaultRetryPolicy(3000, 2, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        Volley.newRequestQueue(_context).add(postRequest);

        return 0;
    }
}
