package com.vmaron.tvinsider.Data.Response;

import com.vmaron.tvinsider.Model.TvShowPagedResults;

public interface TvShowSearchResponse
{
    void processResponse(TvShowPagedResults results);
}
