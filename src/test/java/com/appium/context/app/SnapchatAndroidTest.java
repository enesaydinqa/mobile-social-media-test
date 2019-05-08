package com.appium.context.app;

import com.appium.context.AbstractAndroidTest;
import com.appium.mobile.test.snapchat.SnapchatStoryTest;
import com.appium.pages.snapchat.*;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;


public class SnapchatAndroidTest extends AbstractAndroidTest {
    private SnapchatLoginAction loginPage;
    private LogOut logOut;
    public ProfilePage profilePage;
    public StoryPage storyPage;
    public SendMessage sendMessage;

    public void loginSnapchat(AppiumDriver driver) throws Exception {
        driver.resetApp();
        loginPage = new SnapchatLoginAction(driver);
        waitAndClick(driver, loginPage.loginButton);
        waitElementVisible(driver, loginPage.usernameField);
        waitAndClear(driver, loginPage.usernameField);
        waitAndSendKeys(driver, loginPage.usernameField, "mbcmtestuser");
        waitAndSendKeys(driver, loginPage.passwordField, "mbcm1234");
        waitAndClick(driver, loginPage.loginAction);
        sleep(10);
    }

    public void loginSnapchat(AppiumDriver driver, String username, String password) throws Exception {
        driver.resetApp();
       // acceptAlerts(driver);
        loginPage = new SnapchatLoginAction(driver);
        waitAndClick(driver, loginPage.loginButton);
        waitElementVisible(driver, loginPage.usernameField);
        waitAndClear(driver, loginPage.usernameField);
        waitAndSendKeys(driver, loginPage.usernameField, username);
        waitAndSendKeys(driver, loginPage.passwordField, password);
        waitAndClick(driver, loginPage.loginAction);
       // acceptAlerts(driver);
        sleep(10);
    }
    public void goMessagePage(AppiumDriver driver,String friendsName)  throws Exception{
        storyPage = new StoryPage(driver);
        profilePage = new ProfilePage(driver);
        waitAndClick(driver, storyPage.friends);
        waitAndClick(driver, profilePage.searchFriends);
        waitAndSendKeys(driver, profilePage.searchFriendsText, friendsName);
        waitAndClick(driver, profilePage.firstFriends);
    }
    public void sendMessage(AppiumDriver driver,String message){
        sendMessage = new SendMessage(driver);
        waitAndSendKeys(driver, sendMessage.messageText, message);
        pressEnter(driver);
    }
    public void controlReceivedMessage(AppiumDriver driver,String message){
        sendMessage = new SendMessage(driver);
        int index=getSizeOfList(sendMessage.multipleText);
        String receivedMsg="";
        for(int i=0;i<=index;i++)
        {
            receivedMsg=getAttribute(getElementInList(sendMessage.multipleText, i),"text");
            if(receivedMsg.equals(message)){
                assertEqualsText(message,receivedMsg);
                System.out.println(receivedMsg);
                break;
            }
        }
       // isMobileElementDisplayedOnPage(getElementInList(sendMessage.multipleText, 6));
        //logger.info(receivedMsg);
    }


    public void makeFriends(AppiumDriver driver, String username) throws Exception {
        profilePage = new ProfilePage(driver);
        storyPage = new StoryPage(driver);
        waitAndClick(driver, storyPage.avatarImage);
        clickElementInList(profilePage.findFriends, 4);
        sleep(1);
        waitAndSendKeys(driver, profilePage.searchButton, username);
        sleep(3);
        waitAndClick(driver, profilePage.addFriendsButton);
    }

    public void logoutSnapchat(AppiumDriver driver) throws Exception {
        waitAndClick(driver, logOut.userProfileButton);
        waitAndClick(driver, logOut.settingButton);
        swipeScreen(driver, SwipeDirection.DOWN, 2);
        waitAndClick(driver, logOut.logoutButton);
    }
}
