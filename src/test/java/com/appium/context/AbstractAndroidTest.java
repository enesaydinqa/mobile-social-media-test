package com.appium.context;

import com.appium.client.objects.DeviceInfo;
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

        firstMobile = createAndroidDriver(configuration, 0);

        deviceInfo.setMobileOneDeviceIMEI(getMobileIMEINumber(0));

        if (multipleDevice)
        {
            secondMobile = createAndroidDriver(configuration, 1);

            deviceInfo.setMobileOneDeviceIMEI(getMobileIMEINumber(1));
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

    protected String getMobileUID(int index)
    {
        return deviceManager.getDeviceCapabilities(index).getUid();
    }

    protected String getMobileIMEINumber(int index)
    {
        return deviceManager.getDeviceCapabilities(index).getIMEINumber();
    }

}

