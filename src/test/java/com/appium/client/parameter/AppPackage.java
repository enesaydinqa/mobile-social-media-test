package com.appium.client.parameter;

public enum AppPackage
{
    SNAPCHAT_APP_PACKAGE("com.snapchat.android"),
    INSTAGRAM_APP_PACKAGE("com.instagram.android"),
    YOUTUBE_APP_PACKAGE("com.google.android.youtube");

    public final String appPackage;

    AppPackage(String appPackage)
    {
        this.appPackage = appPackage;
    }
}
