package com.appium.context;

import com.appium.client.objects.DeviceCapabilities;
import com.appium.client.parameter.AppInfo;
import com.appium.client.parameter.AutoGrantPermissions;
import com.appium.client.parameter.NoReset;
import com.appium.utils.Configuration;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;

public abstract class DriverManager extends Events
{

    public AppiumDriver createAndroidDriver(Configuration configuration, String deviceName) throws IOException, InterruptedException
    {
        Capability json = new Capability();

        DeviceCapabilities deviceCapabilities = json.getDeviceCapability(configuration, deviceName);

        AppInfo appInfo = configuration.getAppInfo();
        NoReset noReset = configuration.getNoReset();
        AutoGrantPermissions autoGrantPermissions = configuration.getAutoGrantPermissions();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        try
        {
            capabilities.setCapability("platformName", deviceCapabilities.getPlatformName());
            capabilities.setCapability("platformVersion", deviceCapabilities.getPlatformVersion());
            capabilities.setCapability("deviceName", deviceCapabilities.getDeviceName());
            capabilities.setCapability("appPackage", appInfo.appPackage);
            capabilities.setCapability("appActivity", appInfo.appActivity);
            capabilities.setCapability("unicodeKeyboard", deviceCapabilities.getUnicodeKeyboard());
            capabilities.setCapability("autoGrantPermissions", autoGrantPermissions.autoGrantPermissions);
            capabilities.setCapability("fastReset", deviceCapabilities.getFastReset());
            capabilities.setCapability("noSign", deviceCapabilities.getNoSign());
            capabilities.setCapability("noReset", noReset.noReset);
            capabilities.setCapability("clearDeviceLogsOnStart", deviceCapabilities.getClearDeviceLogsOnStart());
            capabilities.setCapability("automationName", deviceCapabilities.getAutomationName());
            capabilities.setCapability("autoAcceptAlerts", true);
            capabilities.setCapability("disableWindowAnimation", true);
            capabilities.setCapability("waitForAppScript", "$.delay(10000); $.acceptAlert();");

            if (!deviceCapabilities.getUid().equals("NULL"))
            {
                capabilities.setCapability("udid", deviceCapabilities.getUid());
            }
            else
            {
                throw new Exception("Mobile UID Not Found");
            }
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


        appiumRemove(deviceCapabilities.getUid());

        return new AndroidDriver(url, capabilities);
    }

    /**
     * @param uid : device unique id.
     */
    private void appiumRemove(String uid) throws IOException, InterruptedException
    {
        Runtime.getRuntime().exec(String.format("adb -s %s uninstall io.appium.settings", uid));

        sleep(3);
    }

    /**
     * @param deviceServer : appium server ip
     * @param devicePort   : appium server port
     */
    private void startAppiumServer(String deviceServer, String devicePort) throws InterruptedException
    {
        AppiumServiceBuilder builder = new AppiumServiceBuilder();

        builder.withIPAddress(deviceServer);
        builder.usingPort(Integer.valueOf(devicePort));
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");

        AppiumDriverLocalService service = AppiumDriverLocalService.buildService(builder);
        service.start();

        sleep(5);
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
            isServerRunning = true;
        }
        finally
        {
            serverSocket = null;
        }
        return isServerRunning;
    }
}
