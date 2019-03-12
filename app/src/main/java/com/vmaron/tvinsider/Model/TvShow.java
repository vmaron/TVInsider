package com.vmaron.tvinsider.Model;

import java.util.ArrayList;

public class TvShow
{
    private float id;
    private String url;
    private String name;
    private String type;
    private String language;
    ArrayList<Object> genres = new ArrayList<Object>();
    private String status;
    private float runtime;
    private String premiered;
    private String officialSite;
    Schedule scheduleObject;
    Rating RatingObject;
    private float weight;
    Network network;
    private String webChannel = null;
    Externals externalsObject;
    Image imageObject;
    private String summary;
    private float updated;
    Links links;

    // Getter Methods

    public float getId()
    {
        return id;
    }

    public String getUrl()
    {
        return url;
    }

    public String getName()
    {
        return name;
    }

    public String getType()
    {
        return type;
    }

    public String getLanguage()
    {
        return language;
    }

    public String getStatus()
    {
        return status;
    }

    public float getRuntime()
    {
        return runtime;
    }

    public String getPremiered()
    {
        return premiered;
    }

    public String getOfficialSite()
    {
        return officialSite;
    }

    public Schedule getSchedule()
    {
        return scheduleObject;
    }

    public Rating getRating()
    {
        return RatingObject;
    }

    public float getWeight()
    {
        return weight;
    }

    public Network getNetwork()
    {
        return network;
    }

    public String getWebChannel()
    {
        return webChannel;
    }

    public Externals getExternals()
    {
        return externalsObject;
    }

    public Image getImage()
    {
        return imageObject;
    }

    public String getSummary()
    {
        return summary;
    }

    public float getUpdated()
    {
        return updated;
    }

    public Links getLinks()
    {
        return links;
    }

    // Setter Methods

    public void setId(float id)
    {
        this.id = id;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public void setRuntime(float runtime)
    {
        this.runtime = runtime;
    }

    public void setPremiered(String premiered)
    {
        this.premiered = premiered;
    }

    public void setOfficialSite(String officialSite)
    {
        this.officialSite = officialSite;
    }

    public void setSchedule(Schedule scheduleObject)
    {
        this.scheduleObject = scheduleObject;
    }

    public void setRating(Rating ratingObject)
    {
        this.RatingObject = ratingObject;
    }

    public void setWeight(float weight)
    {
        this.weight = weight;
    }

    public void setNetwork(Network networkObject)
    {
        this.network = networkObject;
    }

    public void setWebChannel(String webChannel)
    {
        this.webChannel = webChannel;
    }

    public void setExternals(Externals externalsObject)
    {
        this.externalsObject = externalsObject;
    }

    public void setImage(Image imageObject)
    {
        this.imageObject = imageObject;
    }

    public void setSummary(String summary)
    {
        this.summary = summary;
    }

    public void setUpdated(float updated)
    {
        this.updated = updated;
    }

    public void setLinks(Links _linksObject)
    {
        this.links = _linksObject;
    }
}





