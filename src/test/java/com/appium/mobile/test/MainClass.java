package com.appium.mobile.test;

import com.appium.mobile.test.instagram.InstagramMultipleDeviceTest;
import com.appium.mobile.test.instagram.InstagramSingleDeviceTest;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class MainClass
{
    public static void main(String[] args)
    {
        Result result = null;

        String testType = System.getProperties().getProperty("test.type");

        switch (testType)
        {
            case "INSTAGRAM":
                result = JUnitCore.runClasses(InstagramSingleDeviceTest.class, InstagramMultipleDeviceTest.class);
                break;
        }

        for (Failure failure : result.getFailures())
        {
            System.out.println(failure.toString());
        }
    }


}