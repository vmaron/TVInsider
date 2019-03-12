package com.vmaron.tvinsider.Model;

import java.util.ArrayList;

public class Schedule
{
    private String time;
    ArrayList<Object> days = new ArrayList<Object>();


    // Getter Methods

    public String getTime()
    {
        return time;
    }

    // Setter Methods

    public void setTime(String time)
    {
        this.time = time;
    }
}
