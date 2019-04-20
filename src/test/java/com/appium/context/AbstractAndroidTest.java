package com.appium.context;

import com.appium.client.parameter.DeviceName;
import com.appium.utils.Configuration;
import com.appium.utils.StatusRule;
import io.appium.java_client.AppiumDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;

import static com.appium.utils.ReportInformation.mobileOneDeviceIMEI;
import static com.appium.utils.ReportInformation.mobileSecondDeviceIMEI;

public abstract class AbstractAndroidTest extends DriverManager
{
    protected static AppiumDriver firstMobile;
    protected static AppiumDriver secondMobile;

    public static Configuration configuration;

    @Rule
    public StatusRule statusRule = new StatusRule();

    @Before
    public void init() throws Exception
    {
        init(false);
    }

    public void init(boolean multipleDevice) throws Exception
    {
        configuration = new Configuration();

        firstMobile = createAndroidDriver(configuration, DeviceName.ONE_DEVICE.getDeviceName());

        mobileOneDeviceIMEI = configuration.getMobileOneIMEI();

        if (multipleDevice)
        {
            secondMobile = createAndroidDriver(configuration, DeviceName.SECOND_DEVICE.getDeviceName());

            mobileSecondDeviceIMEI = configuration.getMobileSecondIMEI();
        }

    }

    @After
    public void tearDown()
    {
        if (firstMobile != null)
        {
            try
            {
                firstMobile.closeApp();
                firstMobile.quit();
            }
            catch (Exception ex)
            {
            }

        }

        if (secondMobile != null)
        {
            try
            {
                secondMobile.closeApp();
                secondMobile.quit();
            }
            catch (Exception ex)
            {
            }
        }

        stopAppiumServer();
    }


}

