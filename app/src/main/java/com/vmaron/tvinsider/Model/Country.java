package com.vmaron.tvinsider.Model;

public class Country
{
    private String name;
    private String code;
    private String timezone;


    // Getter Methods

    public String getName()
    {
        return name;
    }

    public String getCode()
    {
        return code;
    }

    public String getTimezone()
    {
        return timezone;
    }

    // Setter Methods

    public void setName(String name)
    {
        this.name = name;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public void setTimezone(String timezone)
    {
        this.timezone = timezone;
    }
}