package com.vmaron.tvinsider.Util;

import android.app.Activity;
import android.content.SharedPreferences;

public class Prefs
{
    SharedPreferences sharedPreferences;

    public Prefs(Activity activity)
    {
        sharedPreferences = activity.getPreferences(activity.MODE_PRIVATE);
    }

    public void setSearch(String search)
    {
        sharedPreferences.edit().putString("search", search).commit();
    }

    public String getSearch()
    {
        return sharedPreferences.getString("search", "million");
    }

}

