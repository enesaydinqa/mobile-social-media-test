package com.appium.utils;

import com.appium.client.parameter.AppInfo;
import com.appium.client.parameter.AutoGrantPermissions;
import com.appium.client.parameter.NoReset;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

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
    private String testResultPath;
    private Operator operator;
    private String[] appiumPort;
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
        this.operator = readOperator();
        this.appiumPort = readAppiumPort();
        this.testResultPath = readTestResultPath();

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

    private Operator readOperator()
    {
        return readOperatorParam("operator");
    }

    private String readTestResultPath()
    {
        return System.getProperties().getProperty("test.result.path");
    }

    private Operator readOperatorParam(String propertyKey)
    {
        Operator operator = null;
        String operatorName = System.getProperties().getProperty(propertyKey);

        if (StringUtils.isNotBlank(operatorName))
        {
            try
            {
                operator = Operator.valueOf(operatorName);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        return operator;
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

    private String[] getInstagramTestUser() throws Exception
    {
        switch (operator)
        {
            case STC:
                return new String[]{configProps.getProperty("stc.instagram.test.user1"), configProps.getProperty("stc.instagram.test.user2")};
            case MOBILY:
                return new String[]{configProps.getProperty("mobily.instagram.test.user1"), configProps.getProperty("mobily.instagram.test.user2")};
            case ZAIN_KSA:
                return new String[]{configProps.getProperty("zain.instagram.test.user1"), configProps.getProperty("zain.instagram.test.user2")};
            default:
                throw new Exception(String.format("instagram test user not set because illegal operator name [%s]", operator));
        }
    }

    private String[] getTwitterTestUser() throws Exception
    {
        switch (operator)
        {
            case STC:
                return new String[]{configProps.getProperty("stc.twitter.test.user1")};
            case MOBILY:
                return new String[]{configProps.getProperty("mobily.twitter.test.user1")};
            case ZAIN_KSA:
                return new String[]{configProps.getProperty("zain.twitter.test.user1")};
            default:
                throw new Exception(String.format("twitter test user not set because illegal operator name [%s]", operator));
        }
    }

    private String[] readAppiumPort() throws Exception
    {
        switch (operator)
        {
            case STC:
                return new String[]{"5555", "5556"};
            case MOBILY:
                return new String[]{"5557", "5558"};
            case ZAIN_KSA:
                return new String[]{"5559", "5560"};
            default:
                throw new Exception(String.format("appium port not set because illegal operator name [%s]", operator));
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

    public String getTestResultPath()
    {
        return testResultPath;
    }

    public void setTestResultPath(String testResultPath)
    {
        this.testResultPath = testResultPath;
    }

    public Operator getOperator()
    {
        return operator;
    }

    public void setOperator(Operator operator)
    {
        this.operator = operator;
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

    public String[] getAppiumPort()
    {
        return appiumPort;
    }

    public void setAppiumPort(String[] appiumPort)
    {
        this.appiumPort = appiumPort;
    }
}
