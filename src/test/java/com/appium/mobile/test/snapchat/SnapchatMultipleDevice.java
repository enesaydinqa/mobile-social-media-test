package com.appium.mobile.test.snapchat;

import com.annotation.Author;
import com.annotation.Contact;
import com.appium.context.app.SnapchatAndroidTest;
import com.appium.pages.snapchat.ProfilePage;
import com.appium.pages.snapchat.SendMessage;
import com.appium.pages.snapchat.StoryPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;;

public class SnapchatMultipleDevice extends SnapchatAndroidTest {
    private Logger logger = Logger.getLogger(SnapchatStoryTest.class);
    //private StoryPage storyPage;
    //private ProfilePage profilePage;
    //private SendMessage sendMessage;

    @Before
    public void init() throws Exception {
        super.init(true);//true
       // storyPage = new StoryPage(firstMobile);
        //profilePage = new ProfilePage(firstMobile);
        //sendMessage = new SendMessage(firstMobile);
    }

    @Test
    @Contact(Author.ATIKE)
    public void sendAndControlMessageWithMultipleDevice() throws Exception {
       // loginSnapchat(firstMobile, "testenerjim@gmail.com", "enerjimE1");
        loginSnapchat(secondMobile, "mbcmtestuser", "mbcm1234");
        goMessagePage(firstMobile,"mbcmtestuser");
        goMessagePage(secondMobile,"enerjim2019");
        //acceptAlerts(secondMobile);
        String text = "Hi this is a test meseage: " +RandomStringUtils.randomAlphanumeric(50);
        sendMessage(firstMobile,text);
        controlReceivedMessage(secondMobile,text);

    }



    @Test
    @Contact(Author.ATIKE)
    public void shareMessage() throws Exception {
        loginSnapchat(firstMobile, "testenerjim@gmail.com", "enerjimE1");
        makeFriends(firstMobile, "mbcmtestuser");
        sendImageToTheFriend();
        sleep(10);
    }

    public void sendImageToTheFriend() throws Exception {
        waitAndClick(firstMobile, storyPage.cameraCaptureButton);
        clickElementInList(storyPage.sendStory, 2);
        // waitAndClick(firstMobile, storyPage.sendButton);
        waitAndSendKeys(firstMobile, storyPage.searchFriends, "mbcmtestuser");
        waitAndClick(firstMobile, storyPage.firstFriendsRow);
    }


}
//        Point point = storyPage.avatarImage.getLocation();
//        int x = point.x;
//        int y = point.y;
//        System.out.println("korrdinatlar x: " + x + " y: " + y);
//        TouchAction touchAction = new TouchAction(firstMobile);
//        touchAction.press(PointOption.point(x, y)).release().perform();


//enes

// isDisplayed(firstMobile, textElement);
//MobileElement textElement = (MobileElement) firstMobile.findElement(By.xpath("//android.widget.TextView[@text='" + text + "']"));
//isDisplayed(firstMobile, textElement);