package com.appium.pages.line;

import com.appium.pages.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class ChatsPage extends PageObject {
    public ChatsPage(AppiumDriver driver) {

        super(driver);
    }

    @AndroidFindBy(className = "android.widget.ImageView")//2
    public List<MobileElement> searchButton;

    @AndroidFindBy(id = "jp.naver.line.android:id/middle_header_button")//2
    public MobileElement searchBtn;

    @AndroidFindBy(id = "jp.naver.line.android:id/searchbar_input_text")
    public MobileElement searchText;

    @AndroidFindBy(className = "android.widget.ImageView")//2
    public List<MobileElement> friendsLink;

    @AndroidFindBy(id = "jp.naver.line.android:id/widget_friend_row_thumbnail")
    public MobileElement firstFriendsRow;

    @AndroidFindBy(className = "android.widget.ImageView")//2
    public List<MobileElement> chatIkon;

    @AndroidFindBy(id = "jp.naver.line.android:id/bnb_button_badge_num")//2
    public MobileElement chatWithNotification;//when receive a messege

    @AndroidFindBy(id = "jp.naver.line.android:id/date")//2
    public MobileElement notificationDate;

    @AndroidFindBy( id = "jp.naver.line.android:id/last_message")//2
    public MobileElement notificationMessage;

    @AndroidFindAll({
            @AndroidBy( xpath = "//androidx.appcompat.app.a.b[@content-desc='Friends']"),//2
            @AndroidBy( accessibility= "Friends")
             })
    public MobileElement friends;


}
