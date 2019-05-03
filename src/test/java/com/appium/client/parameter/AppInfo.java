package com.appium.client.parameter;

import com.sun.xml.internal.ws.api.model.MEP;

public enum AppInfo
{
    SNAPCHAT(AppPackage.SNAPCHAT_APP_PACKAGE, AppActivity.SNAPCHAT_APP_ACTIVITY),
    INSTAGRAM(AppPackage.INSTAGRAM_APP_PACKAGE, AppActivity.INSTAGRAM_APP_ACTIVITY),
    FACEBOOK(AppPackage.FACEBOOK_APP_PACKAGE, AppActivity.FACEBOOK_APP_ACTIVITY),
    MESSENGER(AppPackage.MESSENGER_APP_PACKAGE, AppActivity.MESSENGER_APP_ACTIVITY);

    public final String appPackage;
    public final String appActivity;

    AppInfo(AppPackage appPackage, AppActivity appActivity)
    {
        this.appPackage = appPackage.appPackage;
        this.appActivity = appActivity.appActivity;
    }
}
