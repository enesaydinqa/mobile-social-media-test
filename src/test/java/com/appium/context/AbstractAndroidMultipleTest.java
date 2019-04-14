package com.appium.context;

import com.appium.client.parameter.DeviceName;
import com.appium.utils.Configuration;
import com.appium.utils.StatusRule;
import io.appium.java_client.AppiumDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;

import java.io.IOException;
import java.net.URISyntaxException;

import static com.appium.utils.ReportInformation.mobileOneDeviceIMEI;
import static com.appium.utils.ReportInformation.mobileSecondDeviceIMEI;

public abstract class AbstractAndroidMultipleTest extends DriverManager
{
    protected static AppiumDriver mobileOne;
    protected static AppiumDriver mobileSecond;

    public static Configuration configuration;

    @Rule
    public StatusRule statusRule = new StatusRule();

    @Before
    public void init() throws URISyntaxException, IOException
    {
        configuration = new Configuration();

        mobileOne = createAndroidDriver(configuration, DeviceName.ONE_DEVICE.getDeviceName());

        mobileSecond = createAndroidDriver(configuration, DeviceName.SECOND_DEVICE.getDeviceName());

        mobileOneDeviceIMEI = configuration.getMobileOneIMEI();
        mobileSecondDeviceIMEI = configuration.getMobileSecondIMEI();
    }

    @After
    public void tearDown()
    {
        if (mobileOne != null)
        {
            try
            {
                mobileOne.closeApp();
                mobileOne.quit();
            }
            catch (Exception ex)
            {
            }

        }

        if (mobileSecond != null)
        {
            try
            {
                mobileSecond.closeApp();
                mobileSecond.quit();
            }
            catch (Exception ex)
            {
            }

        }
    }


}

