package com.vmaron.tvinsider.Data.Request;

public class TvShowSearchRequest
{
    public String getQuery()
    {
        return query;
    }

    public int getPage()
    {
        return page;
    }

    public TvShowSearchRequest(String query, int page)
    {
        this.query = query;
        this.page = page;
    }

    private String query;
    private int page;
}
