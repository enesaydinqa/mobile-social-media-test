
package com.appium.utils;

        import com.appium.mobile.test.snapchat.SnapchatStoryTest;

        import com.relevantcodes.extentreports.ExtentReports;
        import com.relevantcodes.extentreports.ExtentTest;
        import com.relevantcodes.extentreports.LogStatus;
        import org.junit.rules.TestWatcher;
        import org.junit.runner.Description;

        import java.io.IOException;


public class SnapchatReportGenerate extends TestWatcher
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

        String reportName = "snapchat_test_report.html";
        //home
        //System.getProperty("user.dir")
//                .concat(configuration.getTestResultPath().concat(System.getProperty("file.separator")))
//                .concat(configuration.getOperator().concat("-"))
//                .concat("Test-Result-snapchat.html");

        ExtentReports extent = new ExtentReports(reportName, false);
        return extent;
    }

    private void flushReports(ExtentReports extent, ExtentTest test)
    {
        extent.endTest(test);
        extent.flush();
    }

    private void reportInformation(ExtentTest test) {

        if (ReportInformation.mobileOneDeviceIMEI != null)
            test.log(LogStatus.INFO, String.format("One Mobile IMEI : %s", ReportInformation.mobileOneDeviceIMEI));

        if (ReportInformation.mobileSecondDeviceIMEI != null)
            test.log(LogStatus.INFO, String.format("Second Mobile IMEI : %s", ReportInformation.mobileSecondDeviceIMEI));

        if (ReportInformation.mobileDeviceOneGeoLocation != null)
            test.log(LogStatus.INFO, String.format("One Mobile Geo Location : %s", ReportInformation.mobileDeviceOneGeoLocation));

        if (ReportInformation.mobileDeviceSecondGeoLocation != null)
            test.log(LogStatus.INFO, String.format("Second Mobile Geo Location : %s", ReportInformation.mobileDeviceSecondGeoLocation));
         if(SnapchatStoryTest.cameraButtonClickTime!= null){
             test.log(LogStatus.INFO,"first step: camera button click time "+SnapchatStoryTest.cameraButtonClickTime);
         }
        if(SnapchatStoryTest.swipeButtonClickTime!= null){
            test.log(LogStatus.INFO,"second step: swipe button click time "+SnapchatStoryTest.swipeButtonClickTime);
        }

        if (SnapchatStoryTest.firstFilter != null) {
            test.log(LogStatus.INFO, "third step: first screenshot result must be like this: " + test.addScreenCapture("snapchat_filter_test_image/first_swipe_filter.png")
            +"   And The test result like this: "+test.addScreenCapture(SnapchatStoryTest.firstFilter)); /*SnapchatStoryTest.s*/

        }
        if (SnapchatStoryTest.secondFilter != null) {
            test.log(LogStatus.INFO, "fourth step: second screenshot result must be like this: " + test.addScreenCapture("snapchat_filter_test_image/second_swipe_filter.png")
                    +"   And The test result like this: "+test.addScreenCapture(SnapchatStoryTest.secondFilter)); /*SnapchatStoryTest.s*/

        }
        ReportInformation.veriableFormat();
    }
}
