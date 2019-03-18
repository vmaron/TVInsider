package com.vmaron.tvinsider.Data;

import android.net.Uri;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.vmaron.tvinsider.Controllers.AppController;
import com.vmaron.tvinsider.Data.Request.TvShowSearchRequest;
import com.vmaron.tvinsider.Data.Response.TvShowSearchResponse;
import com.vmaron.tvinsider.Model.TvShow;
import com.vmaron.tvinsider.Model.TvShowPagedResults;
import com.vmaron.tvinsider.Util.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TvShows
{
    public void search(final TvShowSearchRequest request, final TvShowSearchResponse callBack)
    {
        String url = Uri.parse(Constants.API_URL + "search/tv?" + Constants.API_KEY)
                .buildUpon()
                .appendQueryParameter("query", request.getQuery())
                .appendQueryParameter("page", String.valueOf(request.getPage()))
                .build().toString();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response)
                    {
                        TvShowPagedResults results = new TvShowPagedResults();
                        try
                        {
                            results.setPage(response.getInt("page"));
                            results.setTotalResults(response.getInt("total_results"));
                            results.setTotalPages(response.getInt("total_pages"));

                            JSONArray tvShows = response.getJSONArray("results");
                            for (int i = 0; i < tvShows.length(); i++)
                            {
                                JSONObject o = tvShows.getJSONObject(i);

                                TvShow show = new TvShow();
                                show.setId(o.getInt("id"));
                                show.setName(o.getString("name"));
                                show.setPoster(Constants.POSTER_URL + o.getString("poster_path"));
                                show.setFirstAirDate(o.getString("first_air_date"));
                                show.setVoteAvg(o.getInt("vote_average"));
                                show.setOverview(o.getString("overview"));

                                results.getResults().add(show);
                            }

                        }
                        catch (JSONException e)
                        {
                            e.printStackTrace();
                        }
                        if (null != callBack) callBack.processResponse(results);

                    }
                }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Log.e("Volly Error", error.toString());
            }
        });
        AppController.getInstance().addToRequestQueue(jsonObjectRequest);
    }
}
