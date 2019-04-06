package utils;

import context.AppInfo;
import context.MobileDevice;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration
{
    private Logger logger = Logger.getLogger(Configuration.class);

    private Properties configProps = new Properties();

    private MobileDevice androidMobileDeviceOne;
    private MobileDevice androidMobileDeviceSecond;
    private Boolean unicodeKeyboard;
    private Boolean autoGrantPermissions;
    private Boolean fastReset;
    private Boolean noSign;
    private Boolean noReset;
    private Boolean clearDeviceLogsOnStart;
    private String automationName;
    private String instagramReceiverUsername;

    private AppInfo appInfo;

    public Configuration() throws IOException
    {
        loadConfigProperties();

        this.androidMobileDeviceOne = getAndroidMobileDevicePropOne();
        this.androidMobileDeviceSecond = getAndroidMobileDevicePropSecond();
        this.appInfo = getAppInfoProp();
        this.unicodeKeyboard = Boolean.parseBoolean(configProps.getProperty("unicodeKeyboard"));
        this.autoGrantPermissions = Boolean.parseBoolean(configProps.getProperty("autoGrantPermissions"));
        this.fastReset = Boolean.parseBoolean(configProps.getProperty("fastReset"));
        this.noSign = Boolean.parseBoolean(configProps.getProperty("noSign"));
        this.noReset = Boolean.parseBoolean(configProps.getProperty("noReset"));
        this.clearDeviceLogsOnStart = Boolean.parseBoolean(configProps.getProperty("clearDeviceLogsOnStart"));
        this.automationName = configProps.getProperty("automationName");
        this.instagramReceiverUsername = configProps.getProperty("instagramReceiverUsername");
    }

    private void loadConfigProperties() throws IOException
    {
        String configFile = "configuration.properties";
        InputStream in = ClassLoader.getSystemResourceAsStream(configFile);

        configProps.load(in);
    }

    public MobileDevice getAndroidMobileDeviceOne()
    {
        return androidMobileDeviceOne;
    }

    public MobileDevice getAndroidMobileDeviceSecond()
    {
        return androidMobileDeviceSecond;
    }

    public AppInfo getAppInfo()
    {
        return appInfo;
    }

    private MobileDevice getAndroidMobileDevicePropOne()
    {
        return readMobileDeviceParameter("android.device.mobile.one");
    }

    private MobileDevice getAndroidMobileDevicePropSecond()
    {
        return readMobileDeviceParameter("android.device.mobile.second");
    }

    private AppInfo getAppInfoProp()
    {
        return readAppInfoParameter("test.app.prop");
    }

    private MobileDevice readMobileDeviceParameter(String propertyKey)
    {
        MobileDevice mobileDevice = null;
        String mobileDeviceName = System.getProperties().getProperty(propertyKey);

        if (StringUtils.isNotBlank(mobileDeviceName))
        {
            try
            {
                mobileDevice = MobileDevice.valueOf(mobileDeviceName);

                logger.info(String.format(propertyKey.concat(" : ").concat(mobileDevice.name)));
            }
            catch (Exception e)
            {
                System.out.println("Android Mobile Device is not available, using  [" + mobileDevice.name + "]");
            }
        }

        return mobileDevice;
    }

    private AppInfo readAppInfoParameter(String propertyKey)
    {
        AppInfo appInfo = null;
        String appName = System.getProperties().getProperty(propertyKey);

        if (StringUtils.isNotBlank(appName))
        {
            try
            {
                appInfo = AppInfo.valueOf(appName);

                logger.info(String.format(propertyKey.concat(" : ").concat(appInfo.appPackage)));
                logger.info(String.format(propertyKey.concat(" : ").concat(appInfo.appActivity)));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        return appInfo;
    }

    public Boolean getUnicodeKeyboard()
    {
        return unicodeKeyboard;
    }

    public void setUnicodeKeyboard(Boolean unicodeKeyboard)
    {
        this.unicodeKeyboard = unicodeKeyboard;
    }

    public Boolean getAutoGrantPermissions()
    {
        return autoGrantPermissions;
    }

    public void setAutoGrantPermissions(Boolean autoGrantPermissions)
    {
        this.autoGrantPermissions = autoGrantPermissions;
    }

    public Boolean getFastReset()
    {
        return fastReset;
    }

    public void setFastReset(Boolean fastReset)
    {
        this.fastReset = fastReset;
    }

    public Boolean getNoSign()
    {
        return noSign;
    }

    public void setNoSign(Boolean noSign)
    {
        this.noSign = noSign;
    }

    public Boolean getNoReset()
    {
        return noReset;
    }

    public void setNoReset(Boolean noReset)
    {
        this.noReset = noReset;
    }

    public Boolean getClearDeviceLogsOnStart()
    {
        return clearDeviceLogsOnStart;
    }

    public void setClearDeviceLogsOnStart(Boolean clearDeviceLogsOnStart)
    {
        this.clearDeviceLogsOnStart = clearDeviceLogsOnStart;
    }

    public String getAutomationName()
    {
        return automationName;
    }

    public void setAutomationName(String automationName)
    {
        this.automationName = automationName;
    }

    public String getInstagramReceiverUsername()
    {
        return instagramReceiverUsername;
    }

    public void setInstagramReceiverUsername(String instagramReceiverUsername)
    {
        this.instagramReceiverUsername = instagramReceiverUsername;
    }
}
