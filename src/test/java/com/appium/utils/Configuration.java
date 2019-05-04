package com.appium.utils;

import com.appium.client.parameter.AppInfo;
import com.appium.client.parameter.AutoGrantPermissions;
import com.appium.client.parameter.DeviceName;
import com.appium.client.parameter.NoReset;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration
{
    private Logger logger = Logger.getLogger(Configuration.class);

    private Properties configProps = new Properties();

    private AppInfo appInfo;
    private NoReset noReset;
    private AutoGrantPermissions autoGrantPermissions;
    private String variant;
    private String testResultPath;
    private String operator;
    private String testDevicesPath;
    private String mobileOneUID;
    private String mobileSecondUID;
    private String mobileOneIMEI;
    private String mobileSecondIMEI;
    private String firstInstagramTestUser;
    private String secondInstagramTestUser;
    private String instagramTestUserPassword;
    private String firstTwitterTestUser;
    private String twitterTestUserPassword;

    public Configuration() throws Exception
    {
        loadConfigProperties();

        this.appInfo = getAppInfoProp();
        this.noReset = getNoResetProp();
        this.autoGrantPermissions = getAutoGrantPermissionsProp();
        this.operator = System.getProperties().getProperty("operator");
        this.testResultPath = System.getProperties().getProperty("test.result.path");
        this.variant = readVariant();
        this.testDevicesPath = readTestDevicePath(variant);

        this.mobileOneUID = getDeviceUID(DeviceName.ONE_DEVICE);
        this.mobileSecondUID = getDeviceUID(DeviceName.SECOND_DEVICE);
        this.mobileOneIMEI = getDeviceIMEI(DeviceName.ONE_DEVICE);
        this.mobileSecondIMEI = getDeviceIMEI(DeviceName.SECOND_DEVICE);

        this.firstInstagramTestUser = getInstagramTestUser()[0];
        this.secondInstagramTestUser = getInstagramTestUser()[1];
        this.instagramTestUserPassword = readInstagramTestUserPassword();

        this.firstTwitterTestUser = getTwitterTestUser()[0];
        this.twitterTestUserPassword = readTwitterTestUserPassword();
    }

    private void loadConfigProperties() throws IOException
    {
        String configFile = "configuration.properties";
        InputStream in = ClassLoader.getSystemResourceAsStream(configFile);

        configProps.load(in);
    }

    public AppInfo getAppInfo()
    {
        return appInfo;
    }

    public NoReset getNoReset()
    {
        return noReset;
    }

    public AutoGrantPermissions getAutoGrantPermissions()
    {
        return autoGrantPermissions;
    }

    private AppInfo getAppInfoProp()
    {
        return readAppInfoParam("test.app.prop");
    }

    private NoReset getNoResetProp()
    {
        return readNoResetParam("test.app.prop");
    }

    private AutoGrantPermissions getAutoGrantPermissionsProp()
    {
        return readAutoGrantPermissionsParam("test.app.prop");
    }

    private AppInfo readAppInfoParam(String propertyKey)
    {
        AppInfo appInfo = null;
        String appName = System.getProperties().getProperty(propertyKey);

        if (StringUtils.isNotBlank(appName))
        {
            try
            {
                appInfo = AppInfo.valueOf(appName);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        return appInfo;
    }

    private NoReset readNoResetParam(String propertyKey)
    {
        NoReset noReset = null;
        String appName = System.getProperties().getProperty(propertyKey);

        if (StringUtils.isNotBlank(appName))
        {
            try
            {
                noReset = NoReset.valueOf(appName);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        return noReset;
    }

    private AutoGrantPermissions readAutoGrantPermissionsParam(String propertyKey)
    {
        AutoGrantPermissions autoGrantPermissions = null;
        String appName = System.getProperties().getProperty(propertyKey);

        if (StringUtils.isNotBlank(appName))
        {
            try
            {
                autoGrantPermissions = AutoGrantPermissions.valueOf(appName);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        return autoGrantPermissions;
    }

    private String getDeviceUID(DeviceName deviceName)
    {
        return getDeviceInfo(deviceName, "uid");
    }

    private String getDeviceIMEI(DeviceName deviceName)
    {
        return getDeviceInfo(deviceName, "deviceIMEI");
    }

    private String getDeviceInfo(DeviceName deviceName, String infoName)
    {
        String deviceCapability = ReadFile.readFile(testDevicesPath);

        JSONObject obj = new JSONObject(deviceCapability);

        String info = obj.getJSONObject(deviceName.getDeviceName()).getString(infoName);

        return info;
    }

    private String[] getInstagramTestUser() throws Exception
    {
        switch (operator)
        {
            case "STC":
                return new String[]{configProps.getProperty("stc.instagram.test.user1"), configProps.getProperty("stc.instagram.test.user2")};
            case "Mobily":
                return new String[]{configProps.getProperty("mobily.instagram.test.user1"), configProps.getProperty("mobily.instagram.test.user2")};
            case "Zain":
                return new String[]{configProps.getProperty("zain.instagram.test.user1"), configProps.getProperty("zain.instagram.test.user2")};
            default:
                throw new Exception(String.format("instagram test user not set because illegal operator name [%s]", operator));
        }
    }

    private String[] getTwitterTestUser() throws Exception
    {
        switch (operator)
        {
            case "STC":
                return new String[]{configProps.getProperty("stc.twitter.test.user1")};
            case "Mobily":
                return new String[]{configProps.getProperty("mobily.twitter.test.user1")};
            case "Zain":
                return new String[]{configProps.getProperty("zain.twitter.test.user1")};
            default:
                throw new Exception(String.format("twitter test user not set because illegal operator name [%s]", operator));
        }
    }

    private String readInstagramTestUserPassword()
    {
        return configProps.getProperty("instagram.test.user.password");
    }

    private String readTwitterTestUserPassword()
    {
        return configProps.getProperty("twitter.test.user.password");
    }

    private String readVariant()
    {
        return configProps.getProperty("variant");
    }

    private String readTestDevicePath(String variant)
    {
        String fileSeparator = System.getProperty("file.separator");

        String testDevicePath = null;

        switch (variant)
        {
            case "dev":
                testDevicePath = System.getProperty("user.dir").concat(fileSeparator).concat("src").concat(fileSeparator)
                        .concat("test").concat(fileSeparator).concat("resources").concat(fileSeparator).concat("MobileTestDevices.json");
                break;

            case "prod":
                testDevicePath = System.getProperty("user.home").concat(fileSeparator).concat("MobileTest").concat(fileSeparator)
                        .concat("SocialMediaTestDevices").concat(fileSeparator)
                        .concat("{operator_name}TestDevices.json".replace("{operator_name}", operator));
                break;
        }

        return testDevicePath;
    }

    public String getTestResultPath()
    {
        return testResultPath;
    }

    public void setTestResultPath(String testResultPath)
    {
        this.testResultPath = testResultPath;
    }

    public String getOperator()
    {
        return operator;
    }

    public void setOperator(String operator)
    {
        this.operator = operator;
    }

    public String getMobileOneUID()
    {
        return mobileOneUID;
    }

    public void setMobileOneUID(String mobileOneUID)
    {
        this.mobileOneUID = mobileOneUID;
    }

    public String getMobileSecondUID()
    {
        return mobileSecondUID;
    }

    public void setMobileSecondUID(String mobileSecondUID)
    {
        this.mobileSecondUID = mobileSecondUID;
    }

    public String getMobileOneIMEI()
    {
        return mobileOneIMEI;
    }

    public void setMobileOneIMEI(String mobileOneIMEI)
    {
        this.mobileOneIMEI = mobileOneIMEI;
    }

    public String getMobileSecondIMEI()
    {
        return mobileSecondIMEI;
    }

    public void setMobileSecondIMEI(String mobileSecondIMEI)
    {
        this.mobileSecondIMEI = mobileSecondIMEI;
    }

    public String getFirstInstagramTestUser()
    {
        return firstInstagramTestUser;
    }

    public void setFirstInstagramTestUser(String firstInstagramTestUser)
    {
        this.firstInstagramTestUser = firstInstagramTestUser;
    }

    public String getSecondInstagramTestUser()
    {
        return secondInstagramTestUser;
    }

    public void setSecondInstagramTestUser(String secondInstagramTestUser)
    {
        this.secondInstagramTestUser = secondInstagramTestUser;
    }

    public String getInstagramTestUserPassword()
    {
        return instagramTestUserPassword;
    }

    public String getFirstTwitterTestUser()
    {
        return firstTwitterTestUser;
    }

    public void setFirstTwitterTestUser(String firstTwitterTestUser)
    {
        this.firstTwitterTestUser = firstTwitterTestUser;
    }

    public String getTwitterTestUserPassword()
    {
        return twitterTestUserPassword;
    }

    public void setTwitterTestUserPassword(String twitterTestUserPassword)
    {
        this.twitterTestUserPassword = twitterTestUserPassword;
    }

    public void setInstagramTestUserPassword(String instagramTestUserPassword)
    {
        this.instagramTestUserPassword = instagramTestUserPassword;
    }

    public String getTestDevicesPath()
    {
        return testDevicesPath;
    }

    public void setTestDevicesPath(String testDevicesPath)
    {
        this.testDevicesPath = testDevicesPath;
    }

    public String getVariant()
    {
        return variant;
    }

    public void setVariant(String variant)
    {
        this.variant = variant;
    }
}
