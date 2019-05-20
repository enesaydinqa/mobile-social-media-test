package com.appium.context.app;

import com.appium.context.AbstractAndroidTest;
import com.appium.mobile.test.line.LineMultipleDevice;
import com.appium.pages.line.ChatsPage;
import com.appium.pages.line.MessagePage;
import io.appium.java_client.AppiumDriver;
import org.apache.log4j.Logger;


public class LineAndroidTest extends AbstractAndroidTest {
    private Logger logger = Logger.getLogger(LineMultipleDevice.class);
    private ChatsPage chatsPage;
    private MessagePage messagePage;


    protected void sendStickers(AppiumDriver driver) throws Exception {
        messagePage = new MessagePage(driver);
        waitAndClick(driver, messagePage.emoji);
        waitAndClick(driver, messagePage.stickersChanceButton);
        waitAndClick(driver, messagePage.stickersGrid);
        waitAndClick(driver, messagePage.firstSticker);
        waitAndClick(driver, messagePage.sendButton);
        sleep(2);
    }

    protected void takeAndSendImage(AppiumDriver driver) throws Exception {
        waitAndClick(driver, messagePage.camera);
        waitAndClick(driver, messagePage.presscamera);
        waitAndClick(driver, messagePage.sendcameraimage);
    }


    protected void sendTextMessage(AppiumDriver driver, String message) throws Exception {
        messagePage = new MessagePage(driver);
        waitAndSendKeys(driver, messagePage.textArea, message);
        waitAndClick(driver, messagePage.sendButton);
        getCurrentDate("yyyy/MM/dd");

    }

    protected void goMessagePage(AppiumDriver driver, String friends) throws Exception {
        chatsPage = new ChatsPage(driver);
        messagePage = new MessagePage(driver);
        waitAndClick(driver, messagePage.chatsBtn);
        waitAndClick(driver, chatsPage.searchBtn);
        waitAndSendKeys(driver, chatsPage.searchText, friends);
        waitAndClick(driver, chatsPage.friends);
        sleep(2);
        waitAndClick(driver, chatsPage.firstFriendsRow);
        clickElementInList(chatsPage.chatIkon, 2);
    }

    protected void isMessageReceived(AppiumDriver driver) {
        chatsPage = new ChatsPage(driver);
        waitElementVisible(driver, chatsPage.chatWithNotification);
        isMobileElementDisplayedOnPage(chatsPage.chatWithNotification);
    }


    protected void controlReceivedMessage(AppiumDriver driver, String textMsg) throws Exception {
        chatsPage = new ChatsPage(driver);
        messagePage = new MessagePage(driver);
        String _sizeofnotification;
        String _timeofnotification;
        String _notificationmessage;
        String _messagereceiveddateonpanel;
        int _sizeofelements;
        sleep(2);
        waitAndClick(driver, messagePage.chatsBtn);
        waitElementVisible(driver, chatsPage.chatWithNotification);
        _sizeofnotification = getAttribute(chatsPage.chatWithNotification, "text");
        assertEqualsText(_sizeofnotification, "1");
        _timeofnotification = getAttribute(chatsPage.notificationDate, "text");
        assertEqualsText(getCurrentDate("HH:mm"), _timeofnotification);
        _notificationmessage = getAttribute(chatsPage.notificationMessage, "text");
        assertEqualsText(_notificationmessage, textMsg);
        waitAndClick(driver, chatsPage.notificationMessage, true, "go message page");
        sleep(3);

        _sizeofelements = getSizeOfList(messagePage.receivedDateOnPanel);
        _messagereceiveddateonpanel = getAttribute(getElementInList(messagePage.receivedDateOnPanel, _sizeofelements - 1), "text");
        logger.info(_messagereceiveddateonpanel);

    }


}
