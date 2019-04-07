package context;

import client.parameter.DeviceName;
import io.appium.java_client.AppiumDriver;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import utils.Configuration;

import java.io.IOException;
import java.net.URISyntaxException;

public abstract class AbstractAndroidMultipleTest extends DriverManager
{
    private Logger logger = Logger.getLogger(AbstractAndroidMultipleTest.class);

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

