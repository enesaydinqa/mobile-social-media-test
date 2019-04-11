package com.appium.context;

import com.appium.client.parameter.DeviceName;
import com.appium.utils.Configuration;
import com.appium.utils.ReportGenerate;
import com.appium.utils.StatusRule;
import io.appium.java_client.AppiumDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;

public abstract class AbstractAndroidMultipleTest extends DriverManager
{
    protected static AppiumDriver driverOne;
    protected static AppiumDriver driverSecond;

    public static Configuration configuration;

    @Rule
    public ReportGenerate screenShootRule = new ReportGenerate();

    @Rule
    public StatusRule statusRule = new StatusRule();

    @Before
    public void init() throws URISyntaxException, IOException
    {
        configuration = new Configuration();

        driverOne = createAndroidDriver(configuration, DeviceName.SECOND_DEVICE.getDeviceName());

        driverSecond = createAndroidDriver(configuration, DeviceName.ONE_DEVICE.getDeviceName());
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

