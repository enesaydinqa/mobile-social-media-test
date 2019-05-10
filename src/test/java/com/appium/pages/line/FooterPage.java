package com.appium.pages.line;

import com.appium.pages.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class FooterPage extends PageObject {
    public FooterPage(AppiumDriver driver) {

        super(driver);
    }

    @AndroidFindBy(className = "android.view.View")
    public List<MobileElement> chatsButton;

    @AndroidFindBy(id = "jp.naver.line.android:id/bnb_chat")
    public MobileElement chatsBtn;
}
