package com.appium.pages.instagram;

import com.appium.pages.snapchat.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

public class DirectMessagePage extends PageObject
{
    public DirectMessagePage(AppiumDriver driver)
    {
        super(driver);
    }

    public By sendImage = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.ImageView");

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='New Message']")
    public MobileElement newMessageButton;

    @AndroidFindBy(id = "com.instagram.android:id/recipients_container")
    public MobileElement searchText;

    @AndroidFindBy(id = "com.instagram.android:id/row_user_primary_name")
    public MobileElement searchResultUser;

    @AndroidFindBy(id = "com.instagram.android:id/row_thread_composer_button_gallery")
    public MobileElement galleryButton;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Photo Thumbnail'])[1]")
    public MobileElement photoThumbnail;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Video Thumbnail'])[1]")
    public MobileElement videoThumbnail;

    @AndroidFindBy(id = "com.instagram.android:id/row_thread_composer_edittext")
    public MobileElement messageText;

    @AndroidFindBy(id = "com.instagram.android:id/row_thread_composer_button_send")
    public MobileElement messageSendButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='now']")
    public MobileElement secondAgoMessageText;


    @AndroidFindAll({
            @AndroidBy(id= "com.instagram.android:id/row_thread_composer_button_send"),
            @AndroidBy(id = "com.instagram.android:id/send_button")
    })
    public MobileElement sendButton;

}
