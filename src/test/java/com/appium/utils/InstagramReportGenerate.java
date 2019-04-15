package com.appium.utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import static com.appium.utils.ReportInformation.clickSendMessageTime;
import static com.appium.utils.ReportInformation.instagramPostShareButtonClickTime;
import static com.appium.utils.ReportInformation.instagramSharedImagePostTime;
import static com.appium.utils.ReportInformation.instagramSharedVideoPostTime;
import static com.appium.utils.ReportInformation.mobileDeviceOneGeoLocation;
import static com.appium.utils.ReportInformation.mobileDeviceSecondGeoLocation;
import static com.appium.utils.ReportInformation.mobileOneDeviceIMEI;
import static com.appium.utils.ReportInformation.mobileSecondDeviceIMEI;
import static com.appium.utils.ReportInformation.receiveMessageTime;
import static com.appium.utils.ReportInformation.sendMessageTime;

public class InstagramReportGenerate extends TestWatcher
{
    @Override
    protected void failed(Throwable e, Description description)
    {
        ExtentReports extent = null;
        try
        {
            extent = createReport();
        }
        catch (Exception e1)
        {
            e1.printStackTrace();
        }

        ExtentTest test = extent.startTest(description.getDisplayName());
        test.log(LogStatus.FAIL, "Test Failed");
        test.log(LogStatus.FAIL, "Stack Trace : " + e.toString());

        reportInformation(test);

        flushReports(extent, test);
    }

    @Override
    protected void succeeded(Description description)
    {
        ExtentReports extent = null;
        try
        {
            extent = createReport();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        ExtentTest test = extent.startTest(description.getDisplayName(), "-");

        test.log(LogStatus.PASS, "Test Passed");

        reportInformation(test);

        flushReports(extent, test);
    }


    private ExtentReports createReport() throws Exception
    {
        Configuration configuration = new Configuration();

        String reportName = System.getProperty("user.home")
                .concat(configuration.getTestResultPath().concat(System.getProperty("file.separator")))
                .concat(configuration.getOperator().concat("-"))
                .concat("Test-Result.html");

        ExtentReports extent = new ExtentReports(reportName, false);
        return extent;
    }

    private void flushReports(ExtentReports extent, ExtentTest test)
    {
        extent.endTest(test);
        extent.flush();
    }

    private void reportInformation(ExtentTest test)
    {
        if (mobileOneDeviceIMEI != null)
            test.log(LogStatus.INFO, String.format("One Mobile IMEI : %s", mobileOneDeviceIMEI));

        if (mobileOneDeviceIMEI != null)
            test.log(LogStatus.INFO, String.format("Second Mobile IMEI : %s", mobileSecondDeviceIMEI));

        if (mobileDeviceOneGeoLocation != null)
            test.log(LogStatus.INFO, String.format("One Mobile Geo Location : %s", mobileDeviceOneGeoLocation));

        if (mobileDeviceSecondGeoLocation != null)
            test.log(LogStatus.INFO, String.format("Second Mobile Geo Location : %s", mobileDeviceSecondGeoLocation));

        if (instagramPostShareButtonClickTime != null)
            test.log(LogStatus.INFO, String.format("Instagram Post Share Button Click Time : %s", instagramPostShareButtonClickTime));

        if (instagramSharedImagePostTime != null)
            test.log(LogStatus.INFO, String.format("Instagram Shared Image Post Time : %s", instagramSharedImagePostTime));

        if (instagramSharedVideoPostTime != null)
            test.log(LogStatus.INFO, String.format("Instagram Shared Video Post Time : %s", instagramSharedVideoPostTime));

        if (clickSendMessageTime != null)
            test.log(LogStatus.INFO, String.format("Click Send Message Time : %s", clickSendMessageTime));

        if (sendMessageTime != null)
            test.log(LogStatus.INFO, String.format("Send Message Time : %s", sendMessageTime));

        if (receiveMessageTime != null)
            test.log(LogStatus.INFO, String.format("Receive Message Time : %s", receiveMessageTime));


        mobileOneDeviceIMEI = null;
        mobileSecondDeviceIMEI = null;
        mobileDeviceOneGeoLocation = null;
        mobileDeviceSecondGeoLocation = null;
        instagramPostShareButtonClickTime = null;
        instagramSharedImagePostTime = null;
        instagramSharedVideoPostTime = null;
        clickSendMessageTime = null;
        sendMessageTime = null;
        receiveMessageTime = null;
    }
}
