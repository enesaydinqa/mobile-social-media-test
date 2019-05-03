package com.appium.pages.Messenger;

import com.appium.pages.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends PageObject {
    public HomePage(AppiumDriver driver) {super(driver);}

    @AndroidFindBy(xpath = "")
    public MobileElement selectUser;
}
