package com.appium.utils;

import com.appium.client.objects.DeviceInfo;
import com.appium.client.objects.InstagramReport;
import com.appium.client.objects.TwitterReport;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportInformation
{
    public static void instagramReportFill(DeviceInfo deviceInfo, InstagramReport report, ExtentTest test)
    {
        deviceInformation(deviceInfo, test);

        if (report.getInstagramPostShareButtonClickTime() != null)
        {
            test.log(LogStatus.INFO, String.format("Instagram Post Share Button Click Time : %s", report.getInstagramPostShareButtonClickTime()));
        }

        if (report.getInstagramSharedImagePostTime() != null)
        {
            test.log(LogStatus.INFO, String.format("Instagram Shared Image Post Time : %s", report.getInstagramSharedImagePostTime()));
        }

        if (report.getInstagramSharedVideoPostTime() != null)
        {
            test.log(LogStatus.INFO, String.format("Instagram Shared Video Post Time : %s", report.getInstagramSharedVideoPostTime()));
        }

        if (report.getClickSendMessageTime() != null)
        {
            test.log(LogStatus.INFO, String.format("Click Send Message Time : %s", report.getClickSendMessageTime()));
        }

        if (report.getSendMessageTime() != null)
        {
            test.log(LogStatus.INFO, String.format("Send Message Time : %s", report.getSendMessageTime()));
        }

        if (report.getReceiveMessageTime() != null)
        {
            test.log(LogStatus.INFO, String.format("Receive Message Time : %s", report.getReceiveMessageTime()));
        }
    }

    public static void twitterReportFill(DeviceInfo deviceInfo, TwitterReport report, ExtentTest test)
    {
        deviceInformation(deviceInfo, test);
    }

    private static void deviceInformation(DeviceInfo deviceInfo, ExtentTest test)
    {
        if (deviceInfo.getMobileOneDeviceIMEI() != null)
        {
            test.log(LogStatus.INFO, String.format("One Mobile IMEI : %s", deviceInfo.getMobileOneDeviceIMEI()));
        }

        if (deviceInfo.getMobileSecondDeviceIMEI() != null)
        {
            test.log(LogStatus.INFO, String.format("Second Mobile IMEI : %s", deviceInfo.getMobileSecondDeviceIMEI()));
        }

        if (deviceInfo.getMobileDeviceOneGeoLocation() != null)
        {
            test.log(LogStatus.INFO, String.format("One Mobile Geo Location : %s", deviceInfo.getMobileDeviceOneGeoLocation()));
        }

        if (deviceInfo.getMobileDeviceSecondGeoLocation() != null)
        {
            test.log(LogStatus.INFO, String.format("Second Mobile Geo Location : %s", deviceInfo.getMobileDeviceSecondGeoLocation()));
        }
    }
}
