package com.appium;

import com.appium.mobile.test.instagram.InstagramMultipleDeviceTest;
import com.appium.mobile.test.instagram.InstagramSingleDeviceTest;
import org.junit.runner.JUnitCore;

public class Main {
    public static void main(String[] args) throws Exception {

        String testType = System.getProperties().getProperty("test.app.prop");
        Boolean multipleDeviceTest = Boolean.getBoolean(System.getProperties().getProperty("multiple.device.test"));

        switch (testType) {
            case "INSTAGRAM":
                if (multipleDeviceTest) {
                    JUnitCore.runClasses(InstagramSingleDeviceTest.class, InstagramMultipleDeviceTest.class);
                } else if (!multipleDeviceTest) {
                    JUnitCore.runClasses(InstagramSingleDeviceTest.class);
                }
                break;

            default:
                throw new Exception(String.format("Unidentified Test : %s", testType));
        }
    }
}
