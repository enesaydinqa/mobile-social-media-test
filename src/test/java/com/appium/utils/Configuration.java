package com.appium.utils;

import com.appium.client.parameter.DeviceName;
import com.appium.context.AppInfo;
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
    private String testResultPath;
    private String operator;
    private String instagramReceiverUsername;
    private String mobileOneUID;
    private String mobileSecondUID;
    private String mobileOneIMEI;
    private String mobileSecondIMEI;

    public Configuration() throws IOException
    {
        loadConfigProperties();

        this.appInfo = getAppInfoProp();
        this.instagramReceiverUsername = configProps.getProperty("instagramReceiverUsername");
        this.operator = System.getProperties().getProperty("operator");
        this.testResultPath = System.getProperties().getProperty("testResultPath");

        this.mobileOneUID = getDeviceUID(DeviceName.ONE_DEVICE);
        this.mobileSecondUID = getDeviceUID(DeviceName.SECOND_DEVICE);
        this.mobileOneIMEI = getDeviceIMEI(DeviceName.ONE_DEVICE);
        this.mobileSecondIMEI = getDeviceIMEI(DeviceName.SECOND_DEVICE);
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

    private AppInfo getAppInfoProp()
    {
        return readAppInfoParameter("test.app.prop");
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
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        return appInfo;
    }

    private String getDeviceUID(DeviceName deviceName)
    {
        String devicesJson = String.format(System.getProperty("user.home")
                .concat(System.getProperty("file.separator"))
                .concat("MobileTest")
                .concat(System.getProperty("file.separator"))
                .concat("SocialMediaTestDevices")
                .concat(System.getProperty("file.separator"))
                .concat(String.format("%sTestDevices.json", getOperator())));

        String deviceCapability = ReadFile.readFile(devicesJson);

        JSONObject obj = new JSONObject(deviceCapability);

        String uid = obj.getJSONObject(deviceName.getDeviceName()).getString("uid");

        return uid;
    }

    private String getDeviceIMEI(DeviceName deviceName)
    {
        String devicesJson = String.format(System.getProperty("user.home")
                .concat(System.getProperty("file.separator"))
                .concat("MobileTest")
                .concat(System.getProperty("file.separator"))
                .concat("SocialMediaTestDevices")
                .concat(System.getProperty("file.separator"))
                .concat(String.format("%sTestDevices.json", getOperator())));

        String deviceCapability = ReadFile.readFile(devicesJson);

        JSONObject obj = new JSONObject(deviceCapability);

        String uid = obj.getJSONObject(deviceName.getDeviceName()).getString("deviceIMEI");

        return uid;
    }

    public String getInstagramReceiverUsername()
    {
        return instagramReceiverUsername;
    }

    public void setInstagramReceiverUsername(String instagramReceiverUsername)
    {
        this.instagramReceiverUsername = instagramReceiverUsername;
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
}
