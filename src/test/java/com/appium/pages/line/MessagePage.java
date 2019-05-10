package com.appium.pages.line;

import com.appium.pages.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class MessagePage extends PageObject {
    public MessagePage(AppiumDriver driver) {

        super(driver);
    }

    @AndroidFindBy(className = "android.widget.ImageView")//2
    public List<MobileElement> searchButton;

    @AndroidFindBy(id = "jp.naver.line.android:id/chathistory_message_edit")//2
    public MobileElement textArea;//click

    @AndroidFindBy(id = "jp.naver.line.android:id/chathistory_esk_button")//2
    public MobileElement emoji;

    @AndroidFindBy(id = "jp.naver.line.android:id/chathistory_send_button_image")//2
    public MobileElement voice;

    @AndroidFindBy(id = "jp.naver.line.android:id/chatroom_camera_button")//2
    public MobileElement camera;
    @AndroidFindBy(id = "jp.naver.line.android:id/record_animation")//2
    public MobileElement presscamera;

    @AndroidFindBy(id = "jp.naver.line.android:id/camera_editor_image_send")//2
    public MobileElement sendcameraimage;
    @AndroidFindBy(id = "jp.naver.line.android:id/camera_editor_image_send")//2
    public MobileElement receivedcameraimage;

    //8,9,10,,,,19
    @AndroidFindBy(className = "android.widget.ImageView")//2
    public List<MobileElement> stikers;

    @AndroidFindBy( id = "jp.naver.line.android:id/chathistory_send_button_image")//2
    public MobileElement sendButton;

    @AndroidFindAll({
            @AndroidBy( id = "jp.naver.line.android:id/sticon_input_type_switch"),//cocuk---sticon
            @AndroidBy( id = "jp.naver.line.android:id/sticker_input_type_switch")//yüz---sticker
    })
    public MobileElement stickersChanceButton;

    @AndroidFindBy( id = "jp.naver.line.android:id/chathistory_date_indicator_text")//2
    public MobileElement receiveDate;

    @AndroidFindBy(className = "android.widget.TextView")//son elemennın texti yani tarih kontrol edilecek
    public List<MobileElement> receivedDateOnPanel;

    @AndroidFindAll({
            @AndroidBy(id="jp.naver.line.android:id/sticker_grid"),//swipe right yapılacak
            @AndroidBy(id="jp.naver.line.android:id/sticon_grid_view")
    })
    public MobileElement stickersGrid;

    @AndroidFindBy( id = "jp.naver.line.android:id/sticon_selection_view_sticon_grid_item_image_view")//2
    public MobileElement firstSticker;
}
