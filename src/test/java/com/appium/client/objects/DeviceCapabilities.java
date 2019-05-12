package com.appium.client.objects;

import org.springframework.stereotype.Component;

@Component
public class DeviceCapabilities
{
    private String IMEINumber;
    private String simCard;
    private String platformName;
    private String platformVersion;
    private String deviceName;
    private String uid;
    private String deviceServer;
    private String devicePort;
    private Boolean unicodeKeyboard;
    private Boolean autoGrantPermissions;
    private Boolean fastReset;
    private Boolean noSign;
    private Boolean clearDeviceLogsOnStart;
    private String automationName;

    public String getIMEINumber()
    {
        return IMEINumber;
    }

    public void setIMEINumber(String IMEINumber)
    {
        this.IMEINumber = IMEINumber;
    }

    public String getSimCard()
    {
        return simCard;
    }

    public void setSimCard(String simCard)
    {
        this.simCard = simCard;
    }

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

    @Override
    public String toString()
    {
        return "DeviceCapabilities{" +
                "IMEINumber='" + IMEINumber + '\'' +
                ", simCard='" + simCard + '\'' +
                ", platformName='" + platformName + '\'' +
                ", platformVersion='" + platformVersion + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", uid='" + uid + '\'' +
                ", deviceServer='" + deviceServer + '\'' +
                ", devicePort='" + devicePort + '\'' +
                ", unicodeKeyboard=" + unicodeKeyboard +
                ", autoGrantPermissions=" + autoGrantPermissions +
                ", fastReset=" + fastReset +
                ", noSign=" + noSign +
                ", clearDeviceLogsOnStart=" + clearDeviceLogsOnStart +
                ", automationName='" + automationName + '\'' +
                '}';
    }
}
