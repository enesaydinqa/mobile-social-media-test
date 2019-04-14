package com.appium.utils;

import com.appium.client.date.DateFormatType;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import java.io.IOException;

public class ReportGenerate extends TestWatcher
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
        flushReports(extent, test);
    }


    private ExtentReports createReport() throws IOException
    {
        Configuration configuration = new Configuration();

        String reportName = System.getProperty("user.home") // /users/user.name
                .concat(configuration.getTestResultPath().concat(System.getProperty("file.separator"))) // /Desktop/
                .concat(configuration.getOperator().concat("-")) // STC
                .concat("Test-Result.html");

        ExtentReports extent = new ExtentReports(reportName, false);
        extent.config().reportName("Mobicom Socia Media Tests");
        extent.config().reportHeadline("Mobicom Socia Media Tests");
        return extent;
    }

    private void flushReports(ExtentReports extent, ExtentTest test)
    {
        extent.endTest(test);
        extent.flush();
    }
}
