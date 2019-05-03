package com.appium.client.parameter;

public enum AppActivity
{
    SNAPCHAT_APP_ACTIVITY("com.snapchat.android.LandingPageActivity"),
    INSTAGRAM_APP_ACTIVITY("com.instagram.android.activity.MainTabActivity"),
    FACEBOOK_APP_ACTIVITY("com.facebook.katana.LoginActivity"),
    MESSENGER_APP_ACTIVITY("com.facebook.orca.auth.StartScreenActivity");

    public final String appActivity;

    AppActivity(String appActivity)
    {
        this.appActivity = appActivity;
    }
}
