package com.appium.utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class TwitterReportGenerate extends TestWatcher
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

        String reportName = "test.html";
        //System.getProperty("user.home")
        //        .concat(configuration.getTestResultPath().concat(System.getProperty("file.separator")))
        //         .concat(configuration.getOperator().concat("-"))
        //          .concat("Test-Result.html");

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

        if (ReportInformation.mobileOneDeviceIMEI != null)
            test.log(LogStatus.INFO, String.format("One Mobile IMEI : %s", ReportInformation.mobileOneDeviceIMEI));

        if (ReportInformation.mobileSecondDeviceIMEI != null)
            test.log(LogStatus.INFO, String.format("Second Mobile IMEI : %s", ReportInformation.mobileSecondDeviceIMEI));

        if (ReportInformation.mobileDeviceOneGeoLocation != null)
            test.log(LogStatus.INFO, String.format("One Mobile Geo Location : %s", ReportInformation.mobileDeviceOneGeoLocation));

        if (ReportInformation.mobileDeviceSecondGeoLocation != null)
            test.log(LogStatus.INFO, String.format("Second Mobile Geo Location : %s", ReportInformation.mobileDeviceSecondGeoLocation));

        // if (ReportInformation.instagramPostShareButtonClickTime != null)
        // test.log(LogStatus.INFO, String.format("Instagram Post Share Button Click Time : %s", ReportInformation.instagramPostShareButtonClickTime));

        // if (ReportInformation.instagramSharedImagePostTime != null)
        //  test.log(LogStatus.INFO, String.format("Instagram Shared Image Post Time : %s", ReportInformation.instagramSharedImagePostTime));

        if (ReportInformation.instagramSharedVideoPostTime != null)
            test.log(LogStatus.INFO, String.format("Instagram Shared Video Post Time : %s", ReportInformation.instagramSharedVideoPostTime));

        if (ReportInformation.clickSendMessageTime != null)
            test.log(LogStatus.INFO, String.format("Click Send Message Time : %s", ReportInformation.clickSendMessageTime));

        if (ReportInformation.sendMessageTime != null)
            test.log(LogStatus.INFO, String.format("Send Message Time : %s", ReportInformation.sendMessageTime));

        if (ReportInformation.receiveMessageTime != null)
            test.log(LogStatus.INFO, String.format("Receive Message Time : %s", ReportInformation.receiveMessageTime));

        ReportInformation.veriableFormat();
    }
}
