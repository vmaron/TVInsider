package com.vmaron.tvinsider.Model;

import java.util.ArrayList;

public class TvShowPagedResults
{
    public ArrayList<TvShow> getResults()
    {
        return results;
    }

    public void setResults(ArrayList<TvShow> results)
    {
        this.results = results;
    }

    public int getTotalResults()
    {
        return totalResults;
    }

    public void setTotalResults(int totalResults)
    {
        this.totalResults = totalResults;
    }

    public int getTotalPages()
    {
        return totalPages;
    }

    public void setTotalPages(int totalPages)
    {
        this.totalPages = totalPages;
    }

    public int getPage()
    {
        return page;
    }

    public void setPage(int page)
    {
        this.page = page;
    }

    private ArrayList<TvShow> results = new ArrayList<TvShow>();
    private int totalResults;
    private int totalPages;
    private int page;

}
