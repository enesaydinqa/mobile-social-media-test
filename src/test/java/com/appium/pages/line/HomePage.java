package com.appium.pages.line;

import com.appium.pages.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class HomePage extends PageObject {
    public HomePage(AppiumDriver driver) {

        super(driver);
    }

    @AndroidFindBy(className = "jp.naver.line.android:id/main_view_group")
    public MobileElement notification;
}

