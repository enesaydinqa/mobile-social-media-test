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

import static com.appium.utils.ReportInformation.*;

public abstract class AbstractAndroidSingleTest extends DriverManager
{
    protected static AppiumDriver mobile;

    public static Configuration configuration;

    @Rule
    public StatusRule statusRule = new StatusRule();

    @Before
    public void init() throws URISyntaxException, IOException
    {
        configuration = new Configuration();

        mobile = createAndroidDriver(configuration, DeviceName.ONE_DEVICE.getDeviceName());

        mobileOneDeviceIMEI = configuration.getMobileOneIMEI();
        mobileSecondDeviceIMEI = configuration.getMobileSecondIMEI();
    }

    @After
    public void tearDown()
    {
        if (mobile != null)
        {
            mobile.closeApp();
            mobile.quit();
        }
    }
}

