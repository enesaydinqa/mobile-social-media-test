package com.appium.utils;

import com.appium.context.AppInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration
{
    private Logger logger = Logger.getLogger(Configuration.class);

    private Properties configProps = new Properties();

    private String testResultPath;
    private String operator;
    private String instagramReceiverUsername;
    private AppInfo appInfo;

    public Configuration() throws IOException
    {
        loadConfigProperties();

        this.appInfo = getAppInfoProp();
        this.instagramReceiverUsername = configProps.getProperty("instagramReceiverUsername");
        this.operator = System.getProperties().getProperty("operator");
        this.testResultPath = System.getProperties().getProperty("testResultPath");
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
}
