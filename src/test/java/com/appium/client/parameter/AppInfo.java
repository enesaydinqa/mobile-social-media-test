package com.appium.client.parameter;

public enum AppInfo
{
    SNAPCHAT(AppPackage.SNAPCHAT_APP_PACKAGE, AppActivity.SNAPCHAT_APP_ACTIVITY),
    INSTAGRAM(AppPackage.INSTAGRAM_APP_PACKAGE, AppActivity.INSTAGRAM_APP_ACTIVITY),
    YOUTUBE(AppPackage.YOUTUBE_APP_PACKAGE,AppActivity.YOUTUBE_APP_ACTIVITY);

    public final String appPackage;
    public final String appActivity;

    AppInfo(AppPackage appPackage, AppActivity appActivity)
    {
        this.appPackage = appPackage.appPackage;
        this.appActivity = appActivity.appActivity;
    }
}
