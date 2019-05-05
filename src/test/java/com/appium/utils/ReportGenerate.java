package com.appium.utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import java.io.File;

public abstract class ReportGenerate extends TestWatcher
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

        reportInformation(test);
        test.log(LogStatus.FAIL, "Test Failed");
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

        String folderName = "MobileTestReports";
        String fileSeparator = System.getProperty("file.separator");

        File file = new File(System.getProperty("user.home").concat(fileSeparator).concat(folderName));

        if (!file.exists())
        {
            if (file.mkdir())
            {
                System.out.println("Directory is created!");
            }
            else
            {
                System.out.println("Failed to create directory!");
            }
        }

        String reportName = System.getProperty("user.home")
                .concat(configuration.getTestResultPath().concat(fileSeparator))
                .concat(folderName)
                .concat(System.getProperty("file.separator"))
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

    public void reportInformation(ExtentTest test)
    {
        // Override Method
    }

}
