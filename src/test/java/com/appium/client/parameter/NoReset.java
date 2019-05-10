package com.appium.client.parameter;

public enum NoReset
{
    INSTAGRAM(false),
    SNAPCHAT(false),
    YOUTUBE(true),
    TWITTER(false),
    FACEBOOK(false),
    SKYPE(true),
    LINE(true),
    WHATSAPP(true);

    public Boolean noReset;

    NoReset(Boolean noReset)
    {
        this.noReset = noReset;
    }
}
