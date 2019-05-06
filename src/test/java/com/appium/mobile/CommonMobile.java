package com.appium.mobile;

import com.appium.context.Events;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.List;

public interface CommonMobile
{
    void waitAndClick(AppiumDriver driver, MobileElement mobileElement) throws Exception;

    boolean isDisplayed(AppiumDriver driver, MobileElement element);

    String getGeoLocation(String uid) throws IOException, InterruptedException;

    void sleep(Integer seconds) throws InterruptedException;

    void longPress(AppiumDriver driver, MobileElement element, Integer second) throws InterruptedException;

    void waitNotVisible(AppiumDriver driver, By element);

    void waitElementVisible(AppiumDriver driver, MobileElement element);

    boolean isTextDisplayedOnPage(AppiumDriver driver, String assertText);

    boolean isMobileElementDisplayedOnPage(MobileElement mobileElement);

    void scrollHalfPageDown(AppiumDriver driver);

    void scrollPageUp(AppiumDriver driver);

    void scrollList(List<MobileElement> mobileElementList, AppiumDriver driver);

    void swipeScreen(AppiumDriver driver, Events.SwipeDirection swipeDirection, int repeat);

    void scrollToElement(AppiumDriver driver, MobileElement mobileElement);

    void touchLongPressAction(int startX, int startY, int endX, int endY, int duration, AppiumDriver driver);

    void touchPressAction(int startX, int startY, int endX, int endY, int duration, AppiumDriver driver);

    void coordinateWithClick(AppiumDriver driver, int pointX, int pointY);

    String getAttribute(MobileElement element, String attributeName);
}

