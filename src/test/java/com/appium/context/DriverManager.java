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
import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;

public abstract class DriverManager extends Events
{
    private Logger logger = Logger.getLogger(DriverManager.class);

    private final String appiumServer = "127.0.0.1";

    public AppiumDriver createAndroidDriver(AndroidDriver driver, Configuration configuration, int index) throws IOException, InterruptedException
    {
        AppInfo appInfo = configuration.getAppInfo();
        NoReset noReset = configuration.getNoReset();
        AutoGrantPermissions autoGrantPermissions = configuration.getAutoGrantPermissions();

        boolean isAutoGrantPermission = autoGrantPermissions.autoGrantPermissions;
        boolean isNoReset = noReset.noReset;

        DesiredCapabilities capability = new DesiredCapabilities();

        appiumAppRemove(index);

        if (!checkIfServerIsRunning(configuration.getAppiumPort()[index]))
        {
            startAppiumServer(appiumServer, configuration.getAppiumPort()[index]);
        }

        int counter = 0;

        while (driver == null & counter < 5)
        {
            try
            {
                capability.setCapability("platformName", "Android");
                capability.setCapability("platformVersion", deviceManager.getDeviceCapabilities(index).getPlatformVersion());
                capability.setCapability("udid", deviceManager.getDeviceCapabilities(index).getUid());
                capability.setCapability("deviceName", "Social Media Test Device");
                capability.setCapability("appPackage", appInfo.appPackage);
                capability.setCapability("appActivity", appInfo.appActivity);
                capability.setCapability("unicodeKeyboard", true);
                capability.setCapability("autoGrantPermissions", isAutoGrantPermission);
                capability.setCapability("fastReset", true);
                capability.setCapability("noSign", true);
                capability.setCapability("noReset", isNoReset);
                capability.setCapability("clearDeviceLogsOnStart", true);
                capability.setCapability("automationName", deviceManager.getDeviceCapabilities(index).getAutomationName());
                capability.setCapability("autoAcceptAlerts", true);
                capability.setCapability("disableWindowAnimation", true);
                capability.setCapability("waitForAppScript", "$.delay(10000); $.acceptAlert();");

                logger.info("==============================================================");
                logger.info("====> Start Test Appium Server => " + appiumServer + " : Port => " + configuration.getAppiumPort()[index]);

                String createDriverUrl = "http://" + appiumServer + ":" + configuration.getAppiumPort()[index] + "/wd/hub";

                URL url = new URL(createDriverUrl);

                try
                {
                    driver = new AndroidDriver(url, capability);
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }

                counter++;
            }
            catch (Exception ex)
            {
                // no action
            }
        }

        if (null == driver) throw new NullPointerException("Android Driver is null...");

        return driver;
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

        if (Platform.getCurrent().is(Platform.MAC))
        {
            builder.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"));
        }

        builder.withIPAddress(deviceServer);
        builder.usingPort(Integer.valueOf(devicePort));
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");

        AppiumDriverLocalService service = AppiumDriverLocalService.buildService(builder);
        service.start();

        sleep(10);
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
