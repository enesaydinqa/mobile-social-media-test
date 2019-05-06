package com.appium.client.objects;

public class DeviceInfo
{
    private String mobileOneDeviceIMEI;
    private String mobileSecondDeviceIMEI;
    private String mobileDeviceOneGeoLocation;
    private String mobileDeviceSecondGeoLocation;

    public String getMobileOneDeviceIMEI()
    {
        return mobileOneDeviceIMEI;
    }

    public void setMobileOneDeviceIMEI(String mobileOneDeviceIMEI)
    {
        this.mobileOneDeviceIMEI = mobileOneDeviceIMEI;
    }

    public String getMobileSecondDeviceIMEI()
    {
        return mobileSecondDeviceIMEI;
    }

    public void setMobileSecondDeviceIMEI(String mobileSecondDeviceIMEI)
    {
        this.mobileSecondDeviceIMEI = mobileSecondDeviceIMEI;
    }

    public String getMobileDeviceOneGeoLocation()
    {
        return mobileDeviceOneGeoLocation;
    }

    public void setMobileDeviceOneGeoLocation(String mobileDeviceOneGeoLocation)
    {
        this.mobileDeviceOneGeoLocation = mobileDeviceOneGeoLocation;
    }

    public String getMobileDeviceSecondGeoLocation()
    {
        return mobileDeviceSecondGeoLocation;
    }

    public void setMobileDeviceSecondGeoLocation(String mobileDeviceSecondGeoLocation)
    {
        this.mobileDeviceSecondGeoLocation = mobileDeviceSecondGeoLocation;
    }
}
