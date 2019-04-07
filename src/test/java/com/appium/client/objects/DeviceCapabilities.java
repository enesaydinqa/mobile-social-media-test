package com.appium.client.objects;

public class DeviceCapabilities
{
    private String platformName;
    private String platformVersion;
    private String deviceName;
    private String uid;
    private String deviceServer;
    private String devicePort;
    private Boolean noReset;
    private Boolean unicodeKeyboard;
    private Boolean autoGrantPermissions;
    private Boolean fastReset;
    private Boolean noSign;
    private Boolean clearDeviceLogsOnStart;
    private String automationName;

    public String getPlatformName()
    {
        return platformName;
    }

    public void setPlatformName(String platformName)
    {
        this.platformName = platformName;
    }

    public String getPlatformVersion()
    {
        return platformVersion;
    }

    public void setPlatformVersion(String platformVersion)
    {
        this.platformVersion = platformVersion;
    }

    public String getDeviceName()
    {
        return deviceName;
    }

    public void setDeviceName(String deviceName)
    {
        this.deviceName = deviceName;
    }

    public String getUid()
    {
        return uid;
    }

    public void setUid(String uid)
    {
        this.uid = uid;
    }

    public String getDeviceServer()
    {
        return deviceServer;
    }

    public void setDeviceServer(String deviceServer)
    {
        this.deviceServer = deviceServer;
    }

    public String getDevicePort()
    {
        return devicePort;
    }

    public void setDevicePort(String devicePort)
    {
        this.devicePort = devicePort;
    }

    public Boolean getNoReset()
    {
        return noReset;
    }

    public void setNoReset(Boolean noReset)
    {
        this.noReset = noReset;
    }

    public Boolean getUnicodeKeyboard()
    {
        return unicodeKeyboard;
    }

    public void setUnicodeKeyboard(Boolean unicodeKeyboard)
    {
        this.unicodeKeyboard = unicodeKeyboard;
    }

    public Boolean getAutoGrantPermissions()
    {
        return autoGrantPermissions;
    }

    public void setAutoGrantPermissions(Boolean autoGrantPermissions)
    {
        this.autoGrantPermissions = autoGrantPermissions;
    }

    public Boolean getFastReset()
    {
        return fastReset;
    }

    public void setFastReset(Boolean fastReset)
    {
        this.fastReset = fastReset;
    }

    public Boolean getNoSign()
    {
        return noSign;
    }

    public void setNoSign(Boolean noSign)
    {
        this.noSign = noSign;
    }

    public Boolean getClearDeviceLogsOnStart()
    {
        return clearDeviceLogsOnStart;
    }

    public void setClearDeviceLogsOnStart(Boolean clearDeviceLogsOnStart)
    {
        this.clearDeviceLogsOnStart = clearDeviceLogsOnStart;
    }

    public String getAutomationName()
    {
        return automationName;
    }

    public void setAutomationName(String automationName)
    {
        this.automationName = automationName;
    }
}
