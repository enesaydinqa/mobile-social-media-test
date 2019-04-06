package context;

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

public abstract class AbstractAndroidSingleTest extends Events
{
    private Logger logger = Logger.getLogger(AbstractAndroidSingleTest.class);

    protected static AppiumDriver driver;
    public static MobileDevice mobileDevice;

    private static AppInfo appInfo;
    private static Configuration configuration;

    @Before
    public void init() throws URISyntaxException, IOException
    {
        configuration = new Configuration();

        driver = createAndroidDriver();
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

    private AppiumDriver createAndroidDriver() throws MalformedURLException
    {
        mobileDevice = configuration.getAndroidMobileDeviceOne();
        appInfo = configuration.getAppInfo();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        try
        {
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, mobileDevice.platformName);
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, mobileDevice.platformVersion);
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, mobileDevice.name);
            capabilities.setCapability("appPackage", appInfo.appPackage);
            capabilities.setCapability("appActivity", appInfo.appActivity);
            capabilities.setCapability("unicodeKeyboard", configuration.getUnicodeKeyboard());
            capabilities.setCapability("autoGrantPermissions", configuration.getAutoGrantPermissions());
            capabilities.setCapability("fastReset", configuration.getFastReset());
            capabilities.setCapability("noSign", configuration.getNoReset());
            capabilities.setCapability(MobileCapabilityType.NO_RESET, configuration.getNoReset());
            capabilities.setCapability("clearDeviceLogsOnStart", configuration.getClearDeviceLogsOnStart());
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, configuration.getAutomationName());
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        URL url = null;

        url = new URL("http://" + mobileDevice.serverIp + ":" + mobileDevice.port + "/wd/hub");
        driver = new AndroidDriver(url, capabilities);

        return driver;
    }
}

