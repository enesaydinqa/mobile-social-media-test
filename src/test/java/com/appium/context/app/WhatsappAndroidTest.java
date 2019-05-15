package com.appium.context.app;

import com.appium.context.AbstractAndroidTest;
import com.appium.mobile.test.whatsapp.WhatsappMultipleDeviceTest;
import com.appium.pages.whatsapp.HomePage;
import io.appium.java_client.AppiumDriver;
import org.apache.log4j.Logger;

public class WhatsappAndroidTest extends AbstractAndroidTest {

    private Logger logger = Logger.getLogger(WhatsappMultipleDeviceTest.class);
    protected HomePage homePage;

    protected void sendMessage(AppiumDriver driver) throws Exception {
        homePage = new HomePage(driver);
        waitAndClick(driver, homePage.sendBtn, true, "mesajı gönder");
        isDisplayed(driver, homePage.isdelivered);
    }

    protected void controlMessage(AppiumDriver driver) throws Exception {
        homePage = new HomePage(driver);
        int lg = getSizeOfList(homePage.receivedMessage);
        String s_date = getAttribute(getElementInList(homePage.receivedMessage, lg - 1), "text");
        String s_msg = getAttribute(getElementInList(homePage.receivedMessage, lg - 2), "text");
        logger.info(s_msg + " : " + s_date);
    }

    protected void goMessagePageWithSelectedUser(AppiumDriver driver) throws Exception {
        homePage = new HomePage(driver);
        waitAndClick(driver, homePage.searchBtn, true, "search button click edildi");
        waitAndSendKeys(driver, homePage.searchInput, "Atike");
        waitAndClick(driver, homePage.firstUser, true, "ilk usera git");
        waitAndSendKeys(driver, homePage.typeMsg, "bu bir testtir kusura bakmayın");

    }
}
