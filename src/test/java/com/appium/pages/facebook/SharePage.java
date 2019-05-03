package com.appium.pages.facebook;

import com.appium.pages.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

public class SharePage extends PageObject {

    public SharePage(AppiumDriver driver)
    {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Photo']/android.widget.ImageView")
    public MobileElement photoSelect;

    @AndroidFindBy(xpath = "(//android.widget.FrameLayout[@content-desc='Video'])[1]/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.View")
    public MobileElement videoSelect;
    @AndroidFindBy(xpath = "(//android.widget.FrameLayout[@content-desc='Video'])[2]/android.widget.ImageView[1]")
    public MobileElement videoSelect2;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='NEXT']")
    public MobileElement nextButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='SHARE']")
    public MobileElement shareButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]")
    public MobileElement shareNowButton;

    public By newsFeedRadioButtonNotSelected = By.xpath("//android.view.ViewGroup[@content-desc='News Feed']");

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Selected:News Feed']")
    public MobileElement newsFeedRadioButtonSelected;

    public By yourStoryRadioButtonSelected = By.xpath("//android.view.ViewGroup[@content-desc='Selected:Your story']");

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Your Story']")
    public MobileElement yourStoryRadioButtonNotSelected;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup")
    public MobileElement shareLayout;

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@content-desc='Use Data']/android.widget.TextView")
    public MobileElement useDataPermissions;

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@content-desc='Cancel']/android.widget.TextView")
    public MobileElement useDataPermissionsCancel;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.EditText")
    public MobileElement shareEditText;
}
