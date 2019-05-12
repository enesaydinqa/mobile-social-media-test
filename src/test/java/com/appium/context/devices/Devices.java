package com.appium.context.devices;

import com.appium.client.objects.DeviceCapabilities;

import java.util.List;

public class Devices
{
    private List<DeviceCapabilities> deviceCapabilities;

    public Devices(List<DeviceCapabilities> deviceCapabilities)
    {
        this.deviceCapabilities = deviceCapabilities;
    }

    public List<DeviceCapabilities> getDeviceCapabilities()
    {
        return deviceCapabilities;
    }

    public void setDeviceCapabilities(List<DeviceCapabilities> deviceCapabilities)
    {
        this.deviceCapabilities = deviceCapabilities;
    }
}
