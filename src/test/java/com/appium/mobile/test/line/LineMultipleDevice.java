package com.appium.mobile.test.line;

import com.annotation.Author;
import com.annotation.Contact;
import com.appium.context.app.LineAndroidTest;
import com.appium.pages.line.ChatsPage;
import com.appium.pages.line.FooterPage;
import com.appium.pages.line.HomePage;
import com.appium.pages.line.MessagePage;
import io.appium.java_client.AppiumDriver;
import org.junit.Before;
import org.apache.log4j.Logger;
import org.junit.Test;

public class LineMultipleDevice extends LineAndroidTest {
    private Logger logger = Logger.getLogger(LineMultipleDevice.class);
    private FooterPage footer;
    private ChatsPage chatsPage;
    private MessagePage messagePage;
    private HomePage homePage;

    @Before
    public void init() throws Exception {
        super.init(true);//true
        footer = new FooterPage(firstMobile);
        chatsPage = new ChatsPage(firstMobile);
        messagePage = new MessagePage(firstMobile);
        homePage = new HomePage(firstMobile);
    }

    @Test
    @Contact(Author.ATIKE)
    public void sendMessage() throws Exception {
        goMessagePage(firstMobile, "Testnur Enerjim");//Alike Workman
        sendTextMessage(firstMobile, "bu bir testtir");
        controlReceivedMessage(secondMobile);
        //kontrol kısımları da yapılacak
    }

    @Test
    @Contact(Author.ATIKE)
    public void sendSticker() throws Exception {
        logger.info("test started");
        goMessagePage(firstMobile, "Testnur Enerjim");//Alike Workman
        sendStickers(firstMobile);
        controlReceivedStickers(secondMobile);
        sleep(5);
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