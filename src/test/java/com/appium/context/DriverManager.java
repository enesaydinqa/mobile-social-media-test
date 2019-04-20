package com.appium.context;

import com.appium.client.objects.DeviceCapabilities;
import com.appium.client.parameter.AppInfo;
import com.appium.client.parameter.NoReset;
import com.appium.utils.Configuration;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;

public abstract class DriverManager extends Events
{
    private AppiumDriver driver;
    private AppiumDriverLocalService service;

    public AppiumDriver createAndroidDriver(Configuration configuration, String deviceName) throws IOException, InterruptedException
    {
        Capability json = new Capability();

        DeviceCapabilities deviceCapabilities = json.getDeviceCapability(configuration, deviceName);

        AppInfo appInfo = configuration.getAppInfo();
        NoReset noReset = configuration.getNoReset();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        try
        {
            capabilities.setCapability("platformName", deviceCapabilities.getPlatformName());
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, deviceCapabilities.getPlatformVersion());
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceCapabilities.getDeviceName());
            capabilities.setCapability("appPackage", appInfo.appPackage);
            capabilities.setCapability("appActivity", appInfo.appActivity);
            capabilities.setCapability("unicodeKeyboard", deviceCapabilities.getUnicodeKeyboard());
            capabilities.setCapability("autoGrantPermissions", deviceCapabilities.getAutoGrantPermissions());
            capabilities.setCapability("fastReset", deviceCapabilities.getFastReset());
            capabilities.setCapability("noSign", deviceCapabilities.getNoSign());
            capabilities.setCapability(MobileCapabilityType.NO_RESET, noReset.noReset);
            capabilities.setCapability("clearDeviceLogsOnStart", deviceCapabilities.getClearDeviceLogsOnStart());
            capabilities.setCapability("automationName", deviceCapabilities.getAutomationName());
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        URL url;

        String createDriverUrl = "http://%s:%s/wd/hub";

        url = new URL(String.format(createDriverUrl, deviceCapabilities.getDeviceServer(), deviceCapabilities.getDevicePort()));

        if (!checkIfServerIsRunning(deviceCapabilities.getDevicePort()))
            startAppiumServer(deviceCapabilities.getDeviceServer(), deviceCapabilities.getDevicePort());

        driver = new AndroidDriver(url, capabilities);

        return driver;
    }

    private void startAppiumServer(String deviceServer, String devicePort) throws InterruptedException
    {
        AppiumServiceBuilder builder = new AppiumServiceBuilder();

        builder.withIPAddress(deviceServer);
        builder.usingPort(Integer.valueOf(devicePort));
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");

        service = AppiumDriverLocalService.buildService(builder);
        service.start();

        Thread.sleep(3000);
    }

    private boolean checkIfServerIsRunning(String port)
    {
        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try
        {
            serverSocket = new ServerSocket(Integer.valueOf(port));
            serverSocket.close();
        }
        catch (IOException e)
        {
            //If control comes here, then it means that the port is in use
            isServerRunning = true;
        }
        finally
        {
            serverSocket = null;
        }
        return isServerRunning;
    }
}
