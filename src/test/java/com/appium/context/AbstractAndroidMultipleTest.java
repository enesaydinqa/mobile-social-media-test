package com.appium.context;

import com.appium.client.parameter.DeviceName;
import com.appium.utils.Configuration;
import com.appium.utils.ReportGenerate;
import com.appium.utils.StatusRule;
import io.appium.java_client.AppiumDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;

import java.io.IOException;
import java.net.URISyntaxException;

public abstract class AbstractAndroidMultipleTest extends DriverManager
{
    protected static AppiumDriver mobileOne;
    protected static AppiumDriver mobileSecond;

    public static Configuration configuration;

    @Rule
    public ReportGenerate screenShootRule = new ReportGenerate();

    @Rule
    public StatusRule statusRule = new StatusRule();

    @Before
    public void init() throws URISyntaxException, IOException
    {
        configuration = new Configuration();

        mobileOne = createAndroidDriver(configuration, DeviceName.SECOND_DEVICE.getDeviceName());

        mobileSecond = createAndroidDriver(configuration, DeviceName.ONE_DEVICE.getDeviceName());
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

