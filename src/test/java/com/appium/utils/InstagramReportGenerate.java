package com.appium.utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import java.io.IOException;

import static com.appium.context.DriverManager.*;

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
        catch (IOException e1)
        {
            e1.printStackTrace();
        }

        ExtentTest test = extent.startTest(description.getDisplayName());
        test.log(LogStatus.FAIL, "Stack Trace : " + e.toString());
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
        catch (IOException e)
        {
            e.printStackTrace();
        }

        ExtentTest test = extent.startTest(description.getDisplayName(), "-");

        test.log(LogStatus.PASS, "Test Passed");
        test.log(LogStatus.INFO, String.format("One Mobile Geo Location : %s", mobileDeviceOneGeoLocation));

        if (mobileDeviceSecondGeoLocation != null)
            test.log(LogStatus.INFO, String.format("Second Mobile Geo Location : %s", mobileDeviceSecondGeoLocation));

        flushReports(extent, test);
    }


    private ExtentReports createReport() throws IOException
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
}
