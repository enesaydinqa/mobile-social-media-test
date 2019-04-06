package context;

import client.objects.DeviceCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.Configuration;

import java.io.IOException;
import java.net.URL;

public abstract class DriverManager extends Events
{
    protected static AppiumDriver driver;

    public AppiumDriver createAndroidDriver(Configuration configuration, String deviceName) throws IOException
    {
        JsonCapability jsonCapability = new JsonCapability();

        DeviceCapabilities deviceCapabilities = jsonCapability.getDeviceCapability(deviceName);

        AppInfo appInfo = configuration.getAppInfo();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        try
        {
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, deviceCapabilities.getPlatformName());
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, deviceCapabilities.getPlatformVersion());
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceCapabilities.getDeviceName());
            capabilities.setCapability("appPackage", appInfo.appPackage);
            capabilities.setCapability("appActivity", appInfo.appActivity);
            capabilities.setCapability("unicodeKeyboard", deviceCapabilities.getUnicodeKeyboard());
            capabilities.setCapability("autoGrantPermissions", deviceCapabilities.getAutoGrantPermissions());
            capabilities.setCapability("fastReset", deviceCapabilities.getFastReset());
            capabilities.setCapability("noSign", deviceCapabilities.getNoSign());
            capabilities.setCapability(MobileCapabilityType.NO_RESET, deviceCapabilities.getNoReset());
            capabilities.setCapability("clearDeviceLogsOnStart", deviceCapabilities.getClearDeviceLogsOnStart());
            capabilities.setCapability("automationName", deviceCapabilities.getAutomationName());
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        URL url;

        url = new URL("http://" + deviceCapabilities.getDeviceServer() + ":" + deviceCapabilities.getDevicePort() + "/wd/hub");

        driver = new AndroidDriver(url, capabilities);

        return driver;
    }
}
