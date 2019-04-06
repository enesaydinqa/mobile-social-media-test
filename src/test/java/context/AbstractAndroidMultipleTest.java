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

public abstract class AbstractAndroidMultipleTest extends Events
{
    private Logger logger = Logger.getLogger(AbstractAndroidMultipleTest.class);

    protected static AppiumDriver driverOne;
    protected static AppiumDriver driverSecond;

    public static MobileDevice mobileDeviceOne;
    public static MobileDevice mobileDeviceSecond;

    private static AppInfo appInfo;
    public static Configuration configuration;

    @Before
    public void init() throws URISyntaxException, IOException
    {
        configuration = new Configuration();

        driverOne = createAndroidDriverForDeviceOne();

        driverSecond = createAndroidDriverForDeviceSecond();
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

    private AppiumDriver createAndroidDriverForDeviceOne() throws MalformedURLException
    {
        mobileDeviceOne = configuration.getAndroidMobileDeviceOne();
        mobileDeviceSecond = configuration.getAndroidMobileDeviceSecond();

        appInfo = configuration.getAppInfo();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        try
        {
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, mobileDeviceOne.platformName);
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, mobileDeviceOne.platformVersion);
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, mobileDeviceOne.name);
            capabilities.setCapability("appPackage", appInfo.appPackage);
            capabilities.setCapability("appActivity", appInfo.appActivity);
            capabilities.setCapability("unicodeKeyboard", configuration.getUnicodeKeyboard());
            capabilities.setCapability("autoGrantPermissions", configuration.getAutoGrantPermissions());
            capabilities.setCapability("fastReset", configuration.getFastReset());
            capabilities.setCapability("noSign", configuration.getNoReset());
            capabilities.setCapability(MobileCapabilityType.NO_RESET, configuration.getNoReset());
            capabilities.setCapability("clearDeviceLogsOnStart", configuration.getClearDeviceLogsOnStart());
            capabilities.setCapability("automationName", configuration.getAutomationName());
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        URL url = null;

        url = new URL("http://" + mobileDeviceOne.serverIp + ":" + mobileDeviceOne.port + "/wd/hub");
        driverOne = new AndroidDriver(url, capabilities);

        return driverOne;
    }

    private AppiumDriver createAndroidDriverForDeviceSecond() throws MalformedURLException
    {
        mobileDeviceSecond = configuration.getAndroidMobileDeviceSecond();

        appInfo = configuration.getAppInfo();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        try
        {
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, mobileDeviceSecond.platformName);
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, mobileDeviceSecond.platformVersion);
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, mobileDeviceSecond.name);
            capabilities.setCapability("appPackage", appInfo.appPackage);
            capabilities.setCapability("appActivity", appInfo.appActivity);
            capabilities.setCapability("unicodeKeyboard", configuration.getUnicodeKeyboard());
            capabilities.setCapability("autoGrantPermissions", configuration.getAutoGrantPermissions());
            capabilities.setCapability("fastReset", configuration.getFastReset());
            capabilities.setCapability("noSign", configuration.getNoReset());
            capabilities.setCapability(MobileCapabilityType.NO_RESET, configuration.getNoReset());
            capabilities.setCapability("clearDeviceLogsOnStart", configuration.getClearDeviceLogsOnStart());
            capabilities.setCapability("automationName", configuration.getAutomationName());
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        URL url = null;

        url = new URL("http://" + mobileDeviceSecond.serverIp + ":" + mobileDeviceSecond.port + "/wd/hub");
        driverSecond = new AndroidDriver(url, capabilities);

        return driverSecond;
    }
}

