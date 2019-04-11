package com.appium.mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.io.IOException;

public interface CommonMobile
{
    void waitAndClick(AppiumDriver driver, MobileElement mobileElement);

    boolean isDisplayed(AppiumDriver driver, MobileElement element);

    String getGeoLocation(String uid) throws IOException, InterruptedException;

    void sleep(Integer seconds) throws InterruptedException;

    void longPress(AppiumDriver driver, MobileElement element, Integer second) throws InterruptedException;

    void waitNotVisible(AppiumDriver driver, By element);

    void waitElementVisible(AppiumDriver driver, MobileElement element);
}

