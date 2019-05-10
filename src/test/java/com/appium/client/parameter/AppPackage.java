package com.appium.client.parameter;

public enum AppPackage
{
    SNAPCHAT_APP_PACKAGE("com.snapchat.android"),
    INSTAGRAM_APP_PACKAGE("com.instagram.android"),
    TWITTER_APP_PACKAGE("com.twitter.android"),
    LINE_APP_PACKAGE("jp.naver.line.android");

    public final String appPackage;

    AppPackage(String appPackage)
    {
        this.appPackage = appPackage;
    }
}
