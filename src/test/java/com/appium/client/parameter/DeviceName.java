package com.appium.client.parameter;

public enum DeviceName
{
    ONE_DEVICE("ONE_DEVICE"),
    SECOND_DEVICE("SECOND_DEVICE");

    private final String deviceName;

    DeviceName(String deviceName)
    {
        this.deviceName = deviceName;
    }

    public String getDeviceName()
    {
        return deviceName;
    }
}
