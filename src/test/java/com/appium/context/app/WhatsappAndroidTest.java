package com.appium.context.app;

import com.appium.context.AbstractAndroidTest;
import com.appium.mobile.test.whatsapp.WhatsappMultipleDeviceTest;
import com.appium.pages.whatsapp.HomePage;
import io.appium.java_client.AppiumDriver;
import org.apache.log4j.Logger;

public abstract class WhatsappAndroidTest extends AbstractAndroidTest
{

    private Logger logger = Logger.getLogger(WhatsappMultipleDeviceTest.class);
    protected HomePage homePage;

    protected void sendMessage(AppiumDriver driver, String message) throws Exception
    {
        homePage = new HomePage(driver);
        waitAndSendKeys(driver, homePage.typeMsg, message);
        waitAndClick(driver, homePage.sendBtn);
        isDisplayed(driver, homePage.isdelivered);
    }

    protected void controlMessage(AppiumDriver driver, String message) throws Exception
    {
        homePage = new HomePage(driver);
        assertEqualsText(getAttribute(homePage.notification, "text"), "1");
        waitAndClick(driver, homePage.notification);
        int lg = getSizeOfList(homePage.receivedMessage);
        String s_date = getAttribute(getElementInList(homePage.receivedMessage, lg - 1), "text");
        String s_msg = getAttribute(getElementInList(homePage.receivedMessage, lg - 2), "text");
        assertEqualsText(message, s_msg);
        logger.info(s_msg + " : " + s_date);
    }

    protected void goMessagePageWithSelectedUser(AppiumDriver driver, String friend) throws Exception
    {
        homePage = new HomePage(driver);
        waitAndClick(driver, homePage.searchBtn);
        waitAndSendKeys(driver, homePage.searchInput, friend);
        waitAndClick(driver, homePage.firstUser);
    }

    protected void controlImage(AppiumDriver driver) throws Exception
    {
        homePage = new HomePage(driver);
        assertEqualsText(getAttribute(homePage.notification, "text"), "1");
        waitAndClick(driver, homePage.notification);
        isMobileElementDisplayedOnPage(homePage.photoIcon);
    }

    protected void takeAndSendPhoto(AppiumDriver driver) throws Exception
    {
        homePage = new HomePage(driver);
        waitAndClick(driver, homePage.cmrButton);
        waitAndClick(driver, homePage.takePhoto);
        waitAndClick(driver, homePage.sendBtn);
    }

    protected void cleanNotification(AppiumDriver driver) throws Exception
    {
        homePage = new HomePage(driver);
        if (isMobileElementDisplayedOnPage(homePage.notification))
        {
            waitAndClick(driver, homePage.notification);
            waitAndClick(driver, homePage.back);
        }
        else
        {
            logger.info("there is not any notification");
        }
    }

}
