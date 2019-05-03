package com.appium.client.parameter;

public enum AppPackage
{
    SNAPCHAT_APP_PACKAGE("com.snapchat.android"),
    INSTAGRAM_APP_PACKAGE("com.instagram.android"),
    FACEBOOK_APP_PACKAGE("com.facebook.katana"),
    MESSENGER_APP_PACKAGE("com.facebook.orca");

    public final String appPackage;

    AppPackage(String appPackage)
    {
        this.appPackage = appPackage;
    }
}
