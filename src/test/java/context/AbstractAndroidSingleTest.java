package context;

import client.parameter.DeviceName;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.Configuration;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public abstract class AbstractAndroidSingleTest extends DriverManager
{
    private Logger logger = Logger.getLogger(AbstractAndroidSingleTest.class);

    protected static AppiumDriver driver;

    private static Configuration configuration;

    @Before
    public void init() throws URISyntaxException, IOException
    {
        configuration = new Configuration();

        driver = createAndroidDriver(configuration, DeviceName.SONY_XZ_PREMIUM.deviceName);
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

