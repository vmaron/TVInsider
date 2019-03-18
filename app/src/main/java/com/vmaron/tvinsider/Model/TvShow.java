package com.vmaron.tvinsider.Model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TvShow implements Serializable
{
    private float id;
    private String url;
    private String name;
    private String poster;
    private int voteAvg;
    private String overview;

    public int getVoteAvg()
    {
        return voteAvg;
    }

    public void setVoteAvg(int voteAvg)
    {
        this.voteAvg = voteAvg;
    }

    public String getOverview()
    {
        return overview;
    }

    public void setOverview(String overview)
    {
        this.overview = overview;
    }

    public String getFirstAirDate()
    {
        return firstAirDate;
    }

    public String getFirstAirYear()
    {
        if (this.firstAirDate == null || this.firstAirDate.trim().length() == 0)
            return "";


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try
        {
            Date date = format.parse(this.firstAirDate);
            return new SimpleDateFormat("yyyy").format(date);
        }
        catch (Exception e)
        {

        }
        return "";
    }

    public void setFirstAirDate(String firstAirDate)
    {
        this.firstAirDate = firstAirDate;
    }

    private String firstAirDate;

    public float getId()
    {
        return id;
    }

    public void setId(float id)
    {
        this.id = id;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPoster()
    {
        return poster;
    }

    public void setPoster(String poster)
    {
        this.poster = poster;
    }
}





