package com.vmaron.tvinsider.Model;

public class Links
{
    Self self;
    Episode previousEpisode;
    Episode nextEpisode;


    // Getter Methods

    public Self getSelf()
    {
        return self;
    }

    public Episode getPreviousepisode()
    {
        return previousEpisode;
    }

    public Episode getNextepisode()
    {
        return nextEpisode;
    }

    // Setter Methods

    public void setSelf(Self selfObject)
    {
        this.self = selfObject;
    }

    public void setPreviousepisode(Episode previousepisodeObject)
    {
        this.previousEpisode = previousepisodeObject;
    }

    public void setNextepisode(Episode nextepisodeObject)
    {
        this.nextEpisode = nextepisodeObject;
    }
}
