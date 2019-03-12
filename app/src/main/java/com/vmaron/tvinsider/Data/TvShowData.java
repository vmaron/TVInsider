package com.vmaron.tvinsider.Data;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.vmaron.tvinsider.Controllers.AppController;
import com.vmaron.tvinsider.Model.TvShow;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TvShowData
{
    ArrayList<TvShow> tvShowArrayList = new ArrayList<>();

    public void getTvShows(final TvShowListAsyncResponse callBack)
    {
        String url = "http://api.tvmaze.com/singlesearch/shows?q=american-idol&embed=episodes";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, new Response.Listener<JSONArray>()
        {
            @Override
            public void onResponse(JSONArray response)
            {
                for (int i = 0; i < response.length(); i++)
                {
                    try
                    {
                        JSONObject tvShowObject = response.getJSONObject(i);
                        TvShow quote = new TvShow();
                        quote.setId(tvShowObject.getLong("id"));
                        quote.setName(tvShowObject.getString("name"));

                        Log.d("STUFFF::", tvShowObject.getString("name"));

                        tvShowArrayList.add(quote);

                    }
                    catch (JSONException e)
                    {
                        e.printStackTrace();
                    }

                }
                if (null != callBack) callBack.processFinished(tvShowArrayList);

            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Log.e("Volly Error", error.toString());

            }
        });

        AppController.getInstance().addToRequestQueue(jsonArrayRequest);

    }
}
