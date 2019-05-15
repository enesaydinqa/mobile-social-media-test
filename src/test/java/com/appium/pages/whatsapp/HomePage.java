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

    @AndroidFindBy(id = "com.whatsapp:id/menuitem_search")//2
    public MobileElement searchBtn;//click edilecek

    @AndroidFindBy(id = "com.whatsapp:id/search_src_text")//2
    public MobileElement searchInput;//sendkeys yapılacak

    @AndroidFindBy(id = "com.whatsapp:id/contact_row_container")//2
    public MobileElement firstUser;

    @AndroidFindBy(id = "com.whatsapp:id/entry")//2
    public MobileElement typeMsg;//sendkeys ile mesaj yazılacak

    @AndroidFindBy(id = "com.whatsapp:id/send")//2
    public MobileElement sendBtn;//

    @AndroidFindBy(accessibility = "Delivered")//2
    public MobileElement isdelivered;//

    @AndroidFindBy(className = "android.widget.TextView")//2
    public List<MobileElement> receivedMessage;//last=date ve last-1=last message getAttribute ile içeriği okunacak

}
