package com.appium.context.app;

import com.appium.context.AbstractAndroidTest;
import com.appium.context.MyStringRandomGen;
import com.appium.pages.twitter.HomePage;
import com.appium.pages.twitter.LoginPage;
import io.appium.java_client.AppiumDriver;

public class TwitterAndroidTest extends AbstractAndroidTest {
    private LoginPage loginPage;
    private HomePage homePage;
    public void loginTwitter(AppiumDriver driver, String username, String password) {
        loginPage=new LoginPage(driver);

        locationOfElement(driver,loginPage.loginLink,600);
        waitAndClearInput(loginPage.email);
        waitAndSendKeys(driver,loginPage.email,username);//aktel112@gmail.com
        waitAndClearInput(loginPage.password);
        waitAndSendKeys(driver,loginPage.password,password);
        waitAndClick(driver,loginPage.loginButton,true,"login button is clicked");
    }

    public void exitFromTwitter(AppiumDriver driver){
        homePage=new HomePage(driver);
        waitAndClick(driver,homePage.threeLine,true,"three line is clicked");
        waitAndClick(driver,homePage.settings,true,"settings is clicked");
        waitAndClick(driver,homePage.account,true,"account is clicked");
        scrollHalfPageDown(driver);
        waitAndClick(driver,homePage.exitt,true,"exit is clicked");
        waitAndClick(driver,homePage.yesExit,true,"exit is done");
    }

    public void writeAndSendTweet(AppiumDriver driver){
        homePage=new HomePage(driver);
        MyStringRandomGen msr = new MyStringRandomGen();
        waitAndClick(driver, homePage.tweet, true, "tweet button is clicked");
        waitAndSendKeys(driver, homePage.sendMessage, "this is a test: "+msr.generateRandomString());
        waitAndClick(driver, homePage.sendMessage, true, "send message button is clicked");
    }

}
