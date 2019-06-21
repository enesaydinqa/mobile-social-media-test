package com.appium.context;

import com.appium.client.objects.DeviceInfo;
import com.appium.utils.Configuration;
import com.appium.utils.StatusRule;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;

public abstract class AbstractAndroidTest extends DriverManager
{
    private Logger logger = Logger.getLogger(AbstractAndroidTest.class);

    protected AppiumDriver firstMobile;
    protected AppiumDriver secondMobile;
    private AndroidDriver firstMobileDriver;
    private AndroidDriver secondMobileDriver;
    protected DeviceInfo deviceInfo;

    protected static Configuration configuration;

    @Rule
    public StatusRule statusRule = new StatusRule();

    @Before
    public void init() throws Exception
    {
        init(false);
    }

    protected void init(boolean multipleDevice) throws Exception
    {
        deviceInfo = new DeviceInfo();

        configuration = new Configuration();

        firstMobile = createAndroidDriver(firstMobileDriver, configuration, 0);
        logger.info("first mobile session id : " + firstMobile.getSessionId().toString() + "\n");

        deviceInfo.setMobileOneDeviceIMEI(getMobileIMEINumber(0));

        if (multipleDevice)
        {
            secondMobile = createAndroidDriver(secondMobileDriver, configuration, 1);
            logger.info("second mobile session id : " + secondMobile.getSessionId().toString() + "\n");

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
                // no action
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
                // no action
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

