package com.appium.client.parameter;

public enum NoReset
{

    INSTAGRAM(false),
    SNAPCHAT(true),
    YOUTUBE(true),
    TWITTER(false),
    FACEBOOK(false),
    SKYPE(true),
    WHATSAPP(false);

    public Boolean noReset;

    NoReset(Boolean noReset)
    {
        this.noReset = noReset;
    }
}
