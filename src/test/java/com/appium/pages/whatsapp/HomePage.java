package com.appium.pages.whatsapp;

import com.appium.pages.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class HomePage extends PageObject {
    public HomePage(AppiumDriver driver) {

        super(driver);
    }

    @AndroidFindBy(id = "com.whatsapp:id/menuitem_search")
    public MobileElement searchBtn;

    @AndroidFindBy(id = "com.whatsapp:id/search_src_text")
    public MobileElement searchInput;

    @AndroidFindBy(id = "com.whatsapp:id/contact_row_container")
    public MobileElement firstUser;

    @AndroidFindBy(id = "com.whatsapp:id/entry")
    public MobileElement typeMsg;

    @AndroidFindBy(id = "com.whatsapp:id/send")
    public MobileElement sendBtn;

    @AndroidFindBy(accessibility = "Delivered")
    public MobileElement isdelivered;

    @AndroidFindBy(className = "android.widget.TextView")
    public List<MobileElement> receivedMessage;

    @AndroidFindBy(id = "com.whatsapp:id/camera_btn")
    public MobileElement cmrButton;

    @AndroidFindBy(id = "com.whatsapp:id/shutter")
    public MobileElement takePhoto;

    @AndroidFindBy(id = "com.whatsapp:id/send")
    public MobileElement sendPhoto;

    @AndroidFindBy(id = "com.whatsapp:id/conversations_row_message_count")
    public MobileElement notification;

    @AndroidFindBy(id = "com.whatsapp:id/back")
    public MobileElement back;

    @AndroidFindBy(id = "com.whatsapp:id/media_indicator")
    public MobileElement photoIcon;
}
