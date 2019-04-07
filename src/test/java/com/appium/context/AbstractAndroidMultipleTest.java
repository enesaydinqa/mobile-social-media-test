package com.appium.context;

import com.appium.client.parameter.DeviceName;
import com.appium.utils.Configuration;
import io.appium.java_client.AppiumDriver;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.net.URISyntaxException;

public abstract class AbstractAndroidMultipleTest extends DriverManager
{
    protected static AppiumDriver driverOne;
    protected static AppiumDriver driverSecond;

    public static Configuration configuration;

    @Before
    public void init() throws URISyntaxException, IOException
    {
        configuration = new Configuration();

        driverOne = createAndroidDriver(configuration, DeviceName.SECOND_DEVICE.deviceName);

        driverSecond = createAndroidDriver(configuration, DeviceName.ONE_DEVICE.deviceName);
    }

    @After
    public void tearDown()
    {
        if (driverOne != null)
        {
            try
            {
                driverOne.closeApp();
                driverOne.quit();
            }
            catch (Exception ex)
            {
            }

        }

        if (driverSecond != null)
        {
            try
            {
                driverSecond.closeApp();
                driverSecond.quit();
            }
            catch (Exception ex)
            {
            }

        }
    }


}

