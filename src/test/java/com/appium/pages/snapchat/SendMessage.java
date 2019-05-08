package com.appium.pages.snapchat;

import com.appium.pages.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class SendMessage extends PageObject {
    public SendMessage(AppiumDriver driver)
    {
        super(driver);
    }

    @AndroidFindBy(id="com.snapchat.android:id/neon_header_title")
    public MobileElement searchField;
    @AndroidFindBy(id="com.snapchat.android:id/item")
    public MobileElement sendMessageUser;
    @AndroidFindBy(id="com.snapchat.android:id/chat_input_text_field")
    public MobileElement sendAChat;
    @AndroidFindBy(id= "com.snapchat.android:id/neon_header_back_button")
    public MobileElement backButton;

    @AndroidFindBy(id= "com.snapchat.android:id/chat_input_text_field")
    public MobileElement messageText;

    @AndroidFindBy(xpath= "//android.widget.TextView[@text='Dfg']")
    public MobileElement text;
    @AndroidFindAll({
            @AndroidBy(className = "android.widget.TextView")})//6
    public List<MobileElement> multipleText;
}
