package com.vmaron.tvinsider.Util;

public class StringExtension
{
    public static String truncate(String value, int length)
    {
        if (value != null && value.length() > length)
            value = String.format("%s...", value.substring(0, length));
        return value;
    }
}
