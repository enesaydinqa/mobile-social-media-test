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
    @AndroidFindBy(id = "jp.naver.line.android:id/bnb_chat")
    public MobileElement chatsBtn;

    @AndroidFindBy(id = "jp.naver.line.android:id/chathistory_message_edit")
    public MobileElement textArea;

    @AndroidFindBy(id = "jp.naver.line.android:id/chathistory_esk_button")
    public MobileElement emoji;

    @AndroidFindBy(id = "jp.naver.line.android:id/chatroom_camera_button")
    public MobileElement camera;
    @AndroidFindBy(id = "jp.naver.line.android:id/record_animation")
    public MobileElement presscamera;

    @AndroidFindBy(id = "jp.naver.line.android:id/camera_editor_image_send")
    public MobileElement sendcameraimage;
    @AndroidFindBy(id = "jp.naver.line.android:id/camera_editor_image_send")
    public MobileElement receivedcameraimage;

    @AndroidFindBy( id = "jp.naver.line.android:id/chathistory_send_button_image")
    public MobileElement sendButton;

    @AndroidFindAll({
            @AndroidBy( id = "jp.naver.line.android:id/sticon_input_type_switch"),
            @AndroidBy( id = "jp.naver.line.android:id/sticker_input_type_switch")
    })
    public MobileElement stickersChanceButton;

    @AndroidFindBy(className = "android.widget.TextView")
    public List<MobileElement> receivedDateOnPanel;

    @AndroidFindAll({
            @AndroidBy(id="jp.naver.line.android:id/sticker_grid"),
            @AndroidBy(id="jp.naver.line.android:id/sticon_grid_view")
    })
    public MobileElement stickersGrid;

    @AndroidFindBy( id = "jp.naver.line.android:id/sticon_selection_view_sticon_grid_item_image_view")
    public MobileElement firstSticker;
}
