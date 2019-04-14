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
    private String mobileOneUID;
    private String mobileSecondUID;
    private String mobileOneIMEI;
    private String mobileSecondIMEI;
    private String instagramTestUser1;
    private String instagramTestUser2;
    private String instagramTestUserPassword;

    public Configuration() throws Exception
    {
        loadConfigProperties();

        this.appInfo = getAppInfoProp();
        this.operator = System.getProperties().getProperty("operator");
        this.testResultPath = System.getProperties().getProperty("testResultPath");

        this.mobileOneUID = getDeviceUID(DeviceName.ONE_DEVICE);
        this.mobileSecondUID = getDeviceUID(DeviceName.SECOND_DEVICE);
        this.mobileOneIMEI = getDeviceIMEI(DeviceName.ONE_DEVICE);
        this.mobileSecondIMEI = getDeviceIMEI(DeviceName.SECOND_DEVICE);

        this.instagramTestUser1 = getInstagramTestUser()[0];
        this.instagramTestUser2 = getInstagramTestUser()[1];
        this.instagramTestUserPassword = readInstagramTestUserPassword();
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
        return getDeviceInfo(deviceName, "uid");
    }

    private String getDeviceIMEI(DeviceName deviceName)
    {
        return getDeviceInfo(deviceName, "deviceIMEI");
    }

    private String getDeviceInfo(DeviceName deviceName, String infoName)
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

        String info = obj.getJSONObject(deviceName.getDeviceName()).getString(infoName);

        return info;
    }

    private String[] getInstagramTestUser() throws Exception
    {
        if (operator.equals("STC"))
        {
            String[] users = {configProps.getProperty("stc_instagram.test.user1"), configProps.getProperty("stc_instagram.test.user2")};

            return users;
        }
        else if (operator.equals("MOBILY"))
        {
            String[] users = {configProps.getProperty("mobily_instagram.test.user1"), configProps.getProperty("mobily_instagram.test.user2")};

            return users;
        }
        else if (operator.equals("ZAIN"))
        {
            String[] users = {configProps.getProperty("zain_instagram.test.user1"), configProps.getProperty("zain_instagram.test.user2")};

            return users;
        }
        else
        {
            throw new Exception(String.format("Instagram Test User Not Set Because Illegal Operator Name [%s]", operator));
        }
    }

    private String readInstagramTestUserPassword()
    {
        String instagramTestUserPassword = configProps.getProperty("instagram.test.user.password");

        return instagramTestUserPassword;
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

    public String getInstagramTestUser1()
    {
        return instagramTestUser1;
    }

    public void setInstagramTestUser1(String instagramTestUser1)
    {
        this.instagramTestUser1 = instagramTestUser1;
    }

    public String getInstagramTestUser2()
    {
        return instagramTestUser2;
    }

    public void setInstagramTestUser2(String instagramTestUser2)
    {
        this.instagramTestUser2 = instagramTestUser2;
    }

    public String getInstagramTestUserPassword()
    {
        return instagramTestUserPassword;
    }

    public void setInstagramTestUserPassword(String instagramTestUserPassword)
    {
        this.instagramTestUserPassword = instagramTestUserPassword;
    }
}
