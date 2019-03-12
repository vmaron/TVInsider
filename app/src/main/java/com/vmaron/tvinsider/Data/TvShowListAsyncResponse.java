package com.vmaron.tvinsider.Data;

import com.vmaron.tvinsider.Model.TvShow;

import java.util.ArrayList;

public interface TvShowListAsyncResponse
{
    void processFinished(ArrayList<TvShow> quotes);
}
