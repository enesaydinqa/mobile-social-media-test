package com.appium.context;

import com.appium.client.objects.DeviceInfo;
import com.appium.client.parameter.DeviceName;
import com.appium.utils.Configuration;
import com.appium.utils.StatusRule;
import io.appium.java_client.AppiumDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;

public abstract class AbstractAndroidTest extends DriverManager
{
    protected AppiumDriver firstMobile;
    protected AppiumDriver secondMobile;
    protected DeviceInfo deviceInfo;

    protected Configuration configuration;

    @Rule
    public StatusRule statusRule = new StatusRule();

    @Before
    public void init() throws Exception
    {
        init(false);
    }

    protected void init(boolean multipleDevice) throws Exception
    {
        configuration = new Configuration();
        deviceInfo = new DeviceInfo();

        firstMobile = createAndroidDriver(configuration, DeviceName.ONE_DEVICE.getDeviceName());

        deviceInfo.setMobileOneDeviceIMEI(configuration.getMobileOneIMEI());

        if (multipleDevice)
        {
            secondMobile = createAndroidDriver(configuration, DeviceName.SECOND_DEVICE.getDeviceName());

            deviceInfo.setMobileSecondDeviceIMEI(configuration.getMobileSecondIMEI());
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

    }


}

