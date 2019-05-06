package com.appium.client.parameter;

public enum AutoGrantPermissions
{
    INSTAGRAM(true),
    SNAPCHAT(false),
    YOUTUBE(false),
    TWITTER(true),
    FACEBOOK(false),
    SKYPE(false),
    WHATSAPP(true);

    public Boolean autoGrantPermissions;

    AutoGrantPermissions(Boolean autoGrantPermissions)
    {
        this.autoGrantPermissions = autoGrantPermissions;
    }
}
