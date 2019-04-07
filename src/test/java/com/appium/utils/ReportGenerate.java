package com.appium.utils;

import com.appium.client.date.DateFormatType;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.rules.TestWatcher;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportGenerate extends TestWatcher
{
    private static final DateFormat dateFormat = new SimpleDateFormat(DateFormatType.REPORT_DATE_FORMAT_TYPE.dateFormat);

    @Override
    protected void failed(Throwable e, org.junit.runner.Description description)
    {
        ExtentReports extent = createReport();
        ExtentTest test = extent.startTest(description.getDisplayName());
        test.log(LogStatus.FAIL, "Stack Trace : " + e.toString());
        flushReports(extent, test);
    }

    @Override
    protected void succeeded(org.junit.runner.Description description)
    {
        ExtentReports extent = createReport();
        ExtentTest test = extent.startTest(description.getDisplayName(), "-");

        flushReports(extent, test);
    }


    private ExtentReports createReport()
    {
        Date date = new Date();

        Configuration configuration = null;

        try
        {
            configuration = new Configuration();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }

        String reportName = System.getProperty("user.home") // /users/user.name
                .concat(configuration.getTestResultPath().concat("\\")) // /Desktop/
                .concat(configuration.getOperator().concat("-")) // STC
                .concat("Test-Result-")
                .concat(dateFormat.format(date))
                .concat(".html");


        ExtentReports extent = new ExtentReports(reportName, false);
        extent.config().reportName("Mobicom Socia Media Tests");
        extent.config().reportHeadline("Mo bicom Socia Media Tests");
        return extent;
    }

    private void flushReports(ExtentReports extent, ExtentTest test)
    {
        extent.endTest(test);
        extent.flush();
    }
}
