package com.vmaron.tvinsider.Model;

public class Network
{
    private float id;
    private String name;
    Country country;


    // Getter Methods

    public float getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public Country getCountry()
    {
        return country;
    }

    // Setter Methods

    public void setId(float id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setCountry(Country countryObject)
    {
        this.country = countryObject;
    }
}