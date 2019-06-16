package com.appium.client.objects;

public class SnapchatReport
{
    private String snapchatStoryShareButtonClick;
    private String SharedStoryTime;
    private String receivedMessage;

    public String getSnapchatStoryShareButtonClick()
    {
        return snapchatStoryShareButtonClick;
    }

    public void setSnapchatStoryShareButtonClick(String snapchatStoryShareButtonClick)
    {
        this.snapchatStoryShareButtonClick = snapchatStoryShareButtonClick;
    }

    public String getSharedStoryTime()
    {
        return SharedStoryTime;
    }

    public void setSharedStoryTime(String sharedStoryTime)
    {
        SharedStoryTime = sharedStoryTime;
    }

    public String getReceivedMessage()
    {
        return receivedMessage;
    }

    public void setReceivedMessage(String receivedMessage)
    {
        this.receivedMessage = receivedMessage;
    }
}