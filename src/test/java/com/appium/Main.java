package com.appium;

import com.appium.mobile.test.instagram.InstagramMultipleDeviceTest;
import com.appium.mobile.test.instagram.InstagramSingleDeviceTest;
import org.junit.runner.JUnitCore;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        String testType = System.getProperties().getProperty("test.app.prop");

        switch (testType)
        {
            case "INSTAGRAM":
                JUnitCore.runClasses(InstagramSingleDeviceTest.class, InstagramMultipleDeviceTest.class);
                break;

            default:
                throw new Exception(String.format("Unidentified Test : %s", testType));
        }
    }
}
