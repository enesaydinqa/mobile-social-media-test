package context;

import client.parameter.DeviceName;
import io.appium.java_client.AppiumDriver;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import utils.Configuration;

import java.io.IOException;
import java.net.URISyntaxException;

public abstract class AbstractAndroidSingleTest extends DriverManager
{
    protected static AppiumDriver driver;

    private static Configuration configuration;

    @Before
    public void init() throws URISyntaxException, IOException
    {
        configuration = new Configuration();

        driver = createAndroidDriver(configuration, DeviceName.SECOND_DEVICE.deviceName);
    }

    @After
    public void tearDown()
    {
        if (driver != null)
        {
            driver.closeApp();
            driver.quit();
        }
    }
}

