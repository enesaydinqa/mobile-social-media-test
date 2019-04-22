package com.appium.pages.instagram;

import com.appium.pages.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

public class SearchPage extends PageObject {
    public SearchPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.instagram.android:id/action_bar_search_edit_text")
    public MobileElement searchInput;

    public By searchLoad = By.id("com.instagram.android:id/row_search_for_x_container");
}
