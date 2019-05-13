package com.appium.context.app;

import com.appium.context.AbstractAndroidTest;
import com.appium.mobile.test.line.LineMultipleDevice;
import com.appium.pages.line.ChatsPage;
import com.appium.pages.line.FooterPage;
import com.appium.pages.line.HomePage;
import com.appium.pages.line.MessagePage;
import io.appium.java_client.AppiumDriver;
import org.apache.log4j.Logger;


public class LineAndroidTest extends AbstractAndroidTest {
    private Logger logger = Logger.getLogger(LineMultipleDevice.class);
    private FooterPage footer;
    private ChatsPage chatsPage;
    private MessagePage messagePage;
    private HomePage homePage;


    public void sendStickers(AppiumDriver driver) throws Exception {
        messagePage = new MessagePage(driver);
        waitAndClick(driver, messagePage.emoji);
        waitAndClick(driver, messagePage.stickersChanceButton);
        waitAndClick(driver, messagePage.stickersGrid);
        //clickElementInList(messagePage.stikers, 15);
        waitAndClick(driver, messagePage.firstSticker);
        waitAndClick(driver, messagePage.sendButton);
        sleep(2);
    }
    public void takeAndSendImage(AppiumDriver driver) throws Exception{
        waitAndClick(driver, messagePage.camera);
        waitAndClick(driver, messagePage.presscamera);
        waitAndClick(driver, messagePage.sendcameraimage);
    }


    public void controlReceivedStickers(AppiumDriver driver) throws Exception {
        footer = new FooterPage(driver);
        chatsPage = new ChatsPage(driver);
        messagePage = new MessagePage(driver);
        String _sizeofnotification;
        String _timeofnotification;
        String _notificationmessage;
        String _messagereceiveddateonpanel;
        int _sizeofelements;
        sleep(2);
        waitAndClick(driver, footer.chatsBtn);
        // clickElementInList(footer.chatsButton, 3);
        waitElementVisible(driver, chatsPage.chatWithNotification);

        //read the size of notification
        _sizeofnotification = getAttribute(chatsPage.chatWithNotification, "text");
        logger.info(_sizeofnotification);

        //read time of notifications
        _timeofnotification = getAttribute(chatsPage.notificationDate, "text");
        logger.info(_timeofnotification);

        //read notification message
        _notificationmessage = getAttribute(chatsPage.notificationMessage, "text");
        logger.info(_notificationmessage);

        waitAndClick(driver, chatsPage.notificationMessage, true, "go message page");
        sleep(3);

        _sizeofelements = getSizeOfList(messagePage.receivedDateOnPanel);
        _messagereceiveddateonpanel = getAttribute(getElementInList(messagePage.receivedDateOnPanel, _sizeofelements - 1), "text");
        logger.info(_messagereceiveddateonpanel);

    }

    public void sendTextMessage(AppiumDriver driver, String message) throws Exception {
        messagePage = new MessagePage(driver);
        waitAndSendKeys(driver, messagePage.textArea, message);
        waitAndClick(driver, messagePage.sendButton);

    }

    public void goMessagePage(AppiumDriver driver, String friends) throws Exception {
        footer = new FooterPage(driver);
        chatsPage = new ChatsPage(driver);
        waitAndClick(driver, footer.chatsBtn);
        waitAndClick(driver, chatsPage.searchBtn);
       // clickElementInList(chatsPage.searchBtn, 2);
        waitAndSendKeys(driver, chatsPage.searchText, friends);
        waitAndClick(driver, chatsPage.friends);
        sleep(2);
        waitAndClick(driver, chatsPage.firstFriendsRow);
        clickElementInList(chatsPage.chatIkon, 2);
    }

    public void controlReceivedMessage(AppiumDriver driver) throws Exception {
        footer = new FooterPage(driver);
        chatsPage = new ChatsPage(driver);
        messagePage = new MessagePage(driver);
        String _sizeofnotification;
        String _timeofnotification;
        String _notificationmessage;
        String _messagereceiveddateonpanel;
        int _sizeofelements;
        sleep(2);
        waitAndClick(driver, footer.chatsBtn);
        // clickElementInList(footer.chatsButton, 3);
        waitElementVisible(driver, chatsPage.chatWithNotification);

        //read the size of notification
        _sizeofnotification = getAttribute(chatsPage.chatWithNotification, "text");
        logger.info(_sizeofnotification);

        //read time of notifications
        _timeofnotification = getAttribute(chatsPage.notificationDate, "text");
        logger.info(_timeofnotification);

        //read notification message
        _notificationmessage = getAttribute(chatsPage.notificationMessage, "text");
        logger.info(_notificationmessage);

        waitAndClick(driver, chatsPage.notificationMessage, true, "go message page");
        sleep(3);

        _sizeofelements = getSizeOfList(messagePage.receivedDateOnPanel);
        _messagereceiveddateonpanel = getAttribute(getElementInList(messagePage.receivedDateOnPanel, _sizeofelements - 1), "text");
        logger.info(_messagereceiveddateonpanel);

    }

}
