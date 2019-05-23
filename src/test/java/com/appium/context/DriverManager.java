package com.appium.context;

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
    private final String appiumServer = "127.0.0.1";

    public AppiumDriver createAndroidDriver(Configuration configuration, int index) throws IOException, InterruptedException
    {
        AppInfo appInfo = configuration.getAppInfo();
        NoReset noReset = configuration.getNoReset();
        AutoGrantPermissions autoGrantPermissions = configuration.getAutoGrantPermissions();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        try
        {
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("platformVersion", deviceManager.getDeviceCapabilities(index).getPlatformVersion());
            capabilities.setCapability("udid", deviceManager.getDeviceCapabilities(index).getUid());
            capabilities.setCapability("deviceName", "Social Media Test Device");
            capabilities.setCapability("appPackage", appInfo.appPackage);//appInfo.appPackage
            capabilities.setCapability("appActivity",appInfo.appActivity );//appInfo.appActivity
            capabilities.setCapability("unicodeKeyboard", true);
            capabilities.setCapability("autoGrantPermissions", autoGrantPermissions.autoGrantPermissions);
            capabilities.setCapability("fastReset", true);
            capabilities.setCapability("noSign", true);
            capabilities.setCapability("noReset", noReset.noReset);
            capabilities.setCapability("clearDeviceLogsOnStart", true);
            capabilities.setCapability("automationName", deviceManager.getDeviceCapabilities(index).getAutomationName());
            capabilities.setCapability("autoAcceptAlerts", true);
            capabilities.setCapability("disableWindowAnimation", true);
            capabilities.setCapability("waitForAppScript", "$.delay(10000); $.acceptAlert();");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        URL url;

        String createDriverUrl = "http://" + appiumServer + ":" + configuration.getAppiumPort()[index] + "/wd/hub";

        url = new URL(createDriverUrl);

        if (!checkIfServerIsRunning(configuration.getAppiumPort()[index]))
        {
            startAppiumServer(appiumServer, configuration.getAppiumPort()[index]);
        }

        appiumAppRemove(index);

        return new AndroidDriver(url, capabilities);
    }

    /**
     * @param index : mobile index
     */
    private void appiumAppRemove(int index) throws IOException, InterruptedException
    {
        String uid = deviceManager.getDeviceCapabilities(index).getUid();

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
