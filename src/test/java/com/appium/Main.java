package com.appium;

import com.appium.mobile.test.instagram.InstagramMultipleDeviceTest;
import com.appium.mobile.test.instagram.InstagramSingleDeviceTest;
import com.appium.mobile.test.twitter.TwitterMultipleDeviceTest;
import com.appium.mobile.test.twitter.TwitterSingleDeviceTest;
import org.junit.runner.JUnitCore;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        String testType = System.getProperties().getProperty("test.app.prop");
        boolean multipleDeviceTest = Boolean.getBoolean(System.getProperties().getProperty("multiple.device.test"));

        switch (testType)
        {
            case "INSTAGRAM":

                if (multipleDeviceTest)
                {
                    JUnitCore.runClasses(InstagramSingleDeviceTest.class, InstagramMultipleDeviceTest.class);
                }
                else
                {
                    JUnitCore.runClasses(InstagramSingleDeviceTest.class);
                }
                break;

            case "TWITTER":

                if (multipleDeviceTest)
                {
                    JUnitCore.runClasses(TwitterSingleDeviceTest.class, TwitterMultipleDeviceTest.class);
                }
                else
                {
                    JUnitCore.runClasses(TwitterSingleDeviceTest.class);
                }

            default:
                throw new Exception(String.format("Unidentified Test : %s", testType));
        }
    }
}
