package com.appium.client.date;

public enum DateFormatType
{
    YEAR_MONTH_DAY("yyyy/MM/dd"),
    FULL_DATE("yyyy/MM/dd HH:mm:ss.S"),
    FULL_DATE_OTHER("yyyy-MM-dd HH:mm:ss.S"),
    REPORT_DATE_FORMAT_TYPE("yyyyMMdd-HH");

    public final String dateFormat;

    DateFormatType(String dateFormat)
    {
        this.dateFormat = dateFormat;
    }
}
