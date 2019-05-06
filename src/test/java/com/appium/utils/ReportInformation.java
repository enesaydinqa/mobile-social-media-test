package com.appium.utils;

import com.appium.client.objects.InstagramReport;
import com.appium.client.objects.DeviceInfo;
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
            String info = String.format("Instagram Post Share Button Click Time : %s", report.getInstagramPostShareButtonClickTime());
            test.log(LogStatus.INFO, info);
        }

        if (report.getInstagramSharedImagePostTime() != null)
        {
            String info = String.format("Instagram Shared Image Post Time : %s", report.getInstagramSharedImagePostTime());
            test.log(LogStatus.INFO, info);
        }

        if (report.getInstagramSharedVideoPostTime() != null)
        {
            String info = String.format("Instagram Shared Video Post Time : %s", report.getInstagramSharedVideoPostTime());
            test.log(LogStatus.INFO, info);
        }

        if (report.getClickSendMessageTime() != null)
        {
            String info = String.format("Click Send Message Time : %s", report.getClickSendMessageTime());
            test.log(LogStatus.INFO, info);
        }

        if (report.getSendMessageTime() != null)
        {
            String info = String.format("Send Message Time : %s", report.getSendMessageTime());
            test.log(LogStatus.INFO, info);
        }

        if (report.getReceiveMessageTime() != null)
        {
            String info = String.format("Receive Message Time : %s", report.getReceiveMessageTime());
            test.log(LogStatus.INFO, info);
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
            String info = String.format("One Mobile IMEI : %s", deviceInfo.getMobileOneDeviceIMEI());
            test.log(LogStatus.INFO, info);
        }

        if (deviceInfo.getMobileSecondDeviceIMEI() != null)
        {
            String info = String.format("Second Mobile IMEI : %s", deviceInfo.getMobileSecondDeviceIMEI());
            test.log(LogStatus.INFO, info);
        }

        if (deviceInfo.getMobileDeviceOneGeoLocation() != null)
        {
            String info = String.format("One Mobile Geo Location : %s", deviceInfo.getMobileDeviceOneGeoLocation());
            test.log(LogStatus.INFO, info);
        }

        if (deviceInfo.getMobileDeviceSecondGeoLocation() != null)
        {
            String info = String.format("Second Mobile Geo Location : %s", deviceInfo.getMobileDeviceSecondGeoLocation());
            test.log(LogStatus.INFO, info);
        }
    }
}
