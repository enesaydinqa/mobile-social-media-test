package com.appium.client.parameter;

public enum AutoGrantPermissions
{
    INSTAGRAM(true),
    SNAPCHAT(true),
    YOUTUBE(false),
    TWITTER(true),
    FACEBOOK(false),
    SKYPE(false),
    LINE(true),
    WHATSAPP(true);

    public Boolean autoGrantPermissions;

    AutoGrantPermissions(Boolean autoGrantPermissions)
    {
        this.autoGrantPermissions = autoGrantPermissions;
    }
}
