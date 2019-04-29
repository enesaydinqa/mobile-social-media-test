package com.appium.context.app;

import com.appium.context.AbstractAndroidTest;
import com.appium.context.MyStringRandomGen;
import com.appium.mobile.test.twitter.Twitter;
import com.appium.pages.twitter.HomePage;
import com.appium.pages.twitter.LoginPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.log4j.Logger;

public class TwitterAndroidTest extends AbstractAndroidTest {
    private LoginPage loginPage;
    private HomePage homePage;
    public static String loginBtnClick;
    public Logger logger = Logger.getLogger(Twitter.class);


    public void loginTwitter(AppiumDriver driver, String username, String password) {
        loginPage = new LoginPage(driver);

        locationOfElement(driver, loginPage.loginLink, 600);
        waitAndClearInput(loginPage.email);
        waitAndSendKeys(driver, loginPage.email, username);//aktel112@gmail.com
        waitAndClearInput(loginPage.password);
        waitAndSendKeys(driver, loginPage.password, password);
        loginBtnClick = "login button is clicking";
        waitAndClick(driver, loginPage.loginButton, true, loginBtnClick);
        //logger.info();


    }

    public void exitFromTwitter(AppiumDriver driver) {
        homePage = new HomePage(driver);
        waitAndClick(driver, homePage.threeLine, true, "three line is clicked");
        // test.log(LogStatus.INFO,"three line is clicked");
        waitAndClick(driver, homePage.settings, true, "settings is clicked");
        // test.log(LogStatus.INFO,"settings is clicked");
        waitAndClick(driver, homePage.account, true, "account is clicked");
        //test.log(LogStatus.INFO,"account is clicked");
        scrollHalfPageDown(driver);
        waitAndClick(driver, homePage.exitt, true, "exit is clicked");
        //test.log(LogStatus.INFO,"exit is clicked");
        waitAndClick(driver, homePage.yesExit, true, "exit is done");
    }

    public void writeAndSendTweet(AppiumDriver driver) {
        homePage = new HomePage(driver);
        MyStringRandomGen msr = new MyStringRandomGen();
        waitAndClick(driver, homePage.tweet, true, "tweet button is clicked");
        //test.log(LogStatus.INFO,"tweet button is clicked");
        waitAndSendKeys(driver, homePage.sendMessage, "this is a test: " + msr.generateRandomString());
        //test.log(LogStatus.INFO,"tweet message is written");
        waitAndClick(driver, homePage.sendMessage, true, "send message button is clicked");
        // test.log(LogStatus.INFO,"tweet message is sent");
    }

    public void controlShareMessage(MobileElement element) {
        String msg = getAttribute(element, "contentDescription");
        // String[] divededMsg=split(msg,".");
        String[] divededMsg = msg.split(" ");
        System.out.println(divededMsg[0]);
        for (String a : divededMsg) {
            System.out.println(a);
        }
        // System.out.println(getAttribute(homePage.lastTweet,"contentDescription")) ;

    }

}
