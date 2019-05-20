package com.appium.context;

import com.appium.client.date.DateFormatType;
import com.appium.mobile.CommonMobile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;

public class Events implements CommonMobile
{
    private Logger logger = Logger.getLogger(Events.class);

    private int maxSwipeCount = 5;

    public enum SwipeDirection
    {
        UP, DOWN, LEFT, RIGHT
    }
    public void assertEqualsText(String text1,String text2){
        Assert.assertEquals(text1, text2);
    }

    public void pressEnter(AppiumDriver driver){
        ((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.ENTER);
    }
    public void acceptAlerts(AppiumDriver driver){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }


    public void keyboardEnter(AppiumDriver driver,Boolean log){
        ((AndroidDriver) driver).isKeyboardShown();
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
        driver.hideKeyboard();
    }

    public void clickElementInList(List<MobileElement> elements,int index){
        if (!elements.isEmpty()) {
            elements.get(index).click();
        }
    }

    public int getSizeOfList(List<MobileElement> elements){
        if (!elements.isEmpty()) {
           return elements.size();
        }
        return 0;
    }

    public MobileElement getElementInList(List<MobileElement> elements,int index){
        if (!elements.isEmpty()) {
            return elements.get(index);
        }
        return null;
    }

    public void sendKeysElementInList(List<MobileElement> elements,int index,String text){
        List<MobileElement> profile =elements ;
        if (!profile.isEmpty()) {
            profile.get(index).sendKeys(text);
        }
    }

    @Override
    public void coordinateWithClick(AppiumDriver driver, int pointX, int pointY)
    {
        TouchAction touchAction = new TouchAction(driver);

        touchAction.press(PointOption.point(pointX, pointY)).release().perform();
    }

    @Override
    public String getAttribute(MobileElement element, String attributeName)
    {
        return element.getAttribute(attributeName);
    }

    @Override
    public void waitAndClick(AppiumDriver driver, MobileElement element) throws Exception
    {
        waitAndClick(driver, element, false, null);
    }

    public String waitAndClick(AppiumDriver driver, MobileElement element, Boolean log, String description) throws Exception
    {
        String clickDate = null;

        waitElementToBeClickable(driver, element);
        element.click();
        sleep(1);

        if (log)
        {
            clickDate = getCurrentDate(DateFormatType.FULL_DATE.dateFormat);

            logger.info(description + " : " + clickDate);
        }

        return clickDate;
    }

    public void waitAndSendKeys(AppiumDriver driver, MobileElement element, String Text)
    {
        waitElementVisible(driver, element);
        element.sendKeys(Text);

    }

    public void waitAndClear(AppiumDriver driver, MobileElement element)
    {
        waitElementVisible(driver, element);
        element.clear();
    }

    @Override
    public boolean isDisplayed(AppiumDriver driver, MobileElement element)
    {
        return isDisplayed(driver, element, false, null);
    }

    public Boolean isDisplayed(AppiumDriver driver, MobileElement element, Boolean logDate, String description)
    {
        boolean isDisplayed = false;

        try
        {
            waitElementNotVisible(driver, element);
            element.isDisplayed();
            isDisplayed = true;

            if (logDate)
            {
                logger.info(description + " : " + getCurrentDate(DateFormatType.FULL_DATE.dateFormat));
            }
        }
        catch (Exception ex)
        {
            logger.info("Element Not Displayed --> " + element);
            return isDisplayed;
        }

        return isDisplayed;
    }

    public String getCurrentDate(String dateFormatType)
    {
        DateFormat dateFormat = new SimpleDateFormat(dateFormatType);
        Date date = new Date();
        return dateFormat.format(date);
    }

    @Override
    public void sleep(Integer seconds) throws InterruptedException
    {
        Thread.sleep(seconds * 1000);
    }

    @Override
    public String getGeoLocation(String uid) throws IOException, InterruptedException
    {
        Process proc = Runtime.getRuntime().exec(String.format("adb -s %s shell dumpsys location", uid));

        StringBuilder processOutput = new StringBuilder();

        try (BufferedReader processOutputReader = new BufferedReader(new InputStreamReader(proc.getInputStream())))
        {
            String readLine;

            while ((readLine = processOutputReader.readLine()) != null)
            {
                processOutput.append(readLine + System.lineSeparator());
            }

            proc.waitFor();
        }

        Pattern pattern = Pattern.compile("gps:\\sLocation\\[gps\\s(.+)\\sacc");

        Matcher matcher = pattern.matcher(processOutput.toString());

        String geoLocation = null;

        while (matcher.find())
        {
            geoLocation = matcher.group(0).substring(17, 37);

            logger.info(String.format("GEO LOCATION : %s", geoLocation));
            break;
        }

        return geoLocation;
    }

    @Override
    public void longPress(AppiumDriver driver, MobileElement element, Integer second) throws InterruptedException
    {
        TouchAction action = new TouchAction(driver);
        action.longPress(longPressOptions()
                .withElement(element(element))
                .withDuration(Duration.ofMillis(second * 1000)))
                .release().perform();

        sleep(5);
    }

    @Override
    public void waitNotVisible(AppiumDriver driver, By element)
    {
        waitNotVisible(driver, element, false, null);
    }

    @Override
    public void waitElementVisible(AppiumDriver driver, MobileElement element)
    {
        waitElementVisible(driver, element, false, null);
    }

    public String waitElementVisible(AppiumDriver driver, MobileElement element, Boolean log, String description)
    {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(element));

        String visibleDate = null;

        if (log)
        {
            visibleDate = getCurrentDate(DateFormatType.FULL_DATE.dateFormat);

            logger.info(description + " : " + visibleDate);
        }

        return visibleDate;
    }

    public String waitNotVisible(AppiumDriver driver, By element, Boolean log, String description)
    {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(element));

        String notVisibleDate = null;

        if (log)
        {
            notVisibleDate = getCurrentDate(DateFormatType.FULL_DATE.dateFormat);

            logger.info(description + " : " + notVisibleDate);
        }

        return notVisibleDate;
    }

    public void waitElementToBeClickable(AppiumDriver driver, MobileElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitElementNotVisible(AppiumDriver driver, MobileElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void pushFileMobile(AppiumDriver driver, String mobilePath, String fileName)
    {
        try
        {
            String fileSeparator = System.getProperty("file.separator");

            String uploadFile = System.getProperty("user.home")
                    .concat(fileSeparator)
                    .concat("MobileTest")
                    .concat(fileSeparator)
                    .concat("Media")
                    .concat(fileSeparator)
                    .concat(fileName);

            ((AndroidDriver) driver).pushFile(mobilePath, new File(uploadFile));

            logger.info("=============================================================================================");
            logger.info(String.format("==> Successfull Push File Mobile : %s", mobilePath));
            logger.info("=============================================================================================");
        }
        catch (Exception ex)
        {
            logger.info("Not Successfull Push File Mobile");
        }
    }

    @Override
    public boolean isTextDisplayedOnPage(AppiumDriver driver, String assertText)
    {
        boolean isTextOnPage = false;
        try
        {
            isTextOnPage = driver.findElement(By.xpath("//*[@text='" + assertText + "']")).isDisplayed();
        }
        catch (Exception e)
        {
            logger.info(assertText + " is not displayed on page");
            return isTextOnPage;
        }

        return isTextOnPage;
    }

    @Override
    public boolean isMobileElementDisplayedOnPage(MobileElement mobileElement)
    {
        boolean isTextOnPage = false;
        try
        {
            isTextOnPage = mobileElement.isDisplayed();
        }
        catch (Exception e)
        {
            //nopp
        }
        return isTextOnPage;
    }

    @Override
    public void scrollHalfPageDown(AppiumDriver driver)
    {
        Dimension size = driver.manage().window().getSize();
        int startx = size.width / 5;
        int starty = (int) (size.width * 0.8);
        int endy = (int) (size.width * 0.2);
        touchPressAction(startx, starty, startx, endy, 1000, driver);
    }

    @Override
    public void scrollPageUp(AppiumDriver driver)
    {
        Dimension size = driver.manage().window().getSize();
        int startWidth = size.width / 2;
        int endWidth = size.width / 2;
        int startHeight = (size.height * 23) / 100;
        int endHeight = (size.height * 77) / 100;
        int duration = 1000;

        touchLongPressAction(startWidth, startHeight, endWidth, endHeight, duration, driver);
    }

    @Override
    public void scrollList(List<MobileElement> mobileElementList, AppiumDriver driver)
    {
        int size = mobileElementList.size();

        if (size == 0)
        {
            return;
        }

        int x = mobileElementList.get(0).getLocation().getX();
        int endy = mobileElementList.get(0).getLocation().getY();
        int starty = mobileElementList.get(size - 1).getLocation().getY();
        touchLongPressAction(x, starty, x, endy, 2000, driver);
    }

    public void swipeToElement(AppiumDriver driver, MobileElement mobileElement, boolean isClicked, boolean isHalfDown)
    {
        if (maxSwipeCount == 0)
        {
            logger.info("Element could not found!!!");
            return;
        }

        try
        {
            if (isHalfDown)
            {
                scrollHalfPageDown(driver);
                Assert.assertTrue(mobileElement.isDisplayed());
            }
            else
            {
                swipeScreen(driver, SwipeDirection.DOWN, 1);
                Assert.assertTrue(mobileElement.isDisplayed());
            }

            if (isClicked)
            {
                waitAndClick(driver, mobileElement);
            }
        }
        catch (Exception e)
        {
            logger.info("Element could not found! Screen will be swiped one more time.");
            maxSwipeCount--;
            swipeToElement(driver, mobileElement, isClicked);
        }
    }

    @Override
    public void swipeScreen(AppiumDriver driver, SwipeDirection swipeDirection, int repeat)
    {
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();
        int startX, startY, endX, endY;

        for (int i = 0; i < repeat; i++)
        {
            TouchAction touchAction = new TouchAction(driver);
            switch (swipeDirection)
            {
                case UP:
                    startX = screenWidth / 2;
                    endX = startX;
                    startY = (int) (0.2 * screenHeight);
                    endY = (int) (0.65 * screenHeight);
                    touchAction.press(point(startX, startY)).waitAction(waitOptions(Duration.ofMillis(400))).moveTo(point(endX, endY)).release();
                    break;
                case DOWN:
                    startX = screenWidth / 2;
                    endX = startX;
                    startY = (int) (0.65 * screenHeight);
                    endY = (int) (0.35 * screenHeight);
                    touchAction.press(point(startX, startY)).waitAction(waitOptions(Duration.ofMillis(400))).moveTo(point(endX, endY)).release();
                    break;
                case LEFT:
                    startX = (int) (0.2 * screenWidth);
                    startY = screenHeight / 2;
                    endX = (int) (0.65 * screenWidth);
                    touchAction.press(point(startX, startY)).waitAction(waitOptions(Duration.ofMillis(400))).moveTo(point(endX, startY)).release();
                    break;
                case RIGHT:
                    startX = (int) (0.65 * screenWidth);
                    startY = screenHeight / 2;
                    endX = (int) (0.2 * screenWidth);
                    touchAction.press(point(startX, startY)).waitAction(waitOptions(Duration.ofMillis(400))).moveTo(point(endX, startY)).release();
                    break;
            }
            touchAction.perform();
        }
    }

    @Override
    public void scrollToElement(AppiumDriver driver, MobileElement mobileElement)
    {
        try
        {
            int counter = 0;
            while (!isDisplayed(driver, mobileElement) && counter < 5)
            {
                swipeScreen(driver, SwipeDirection.DOWN, 1);
                counter++;
            }

            if (!isDisplayed(driver, mobileElement))
            {
                swipeScreen(driver, SwipeDirection.UP, 5);
            }

        }
        catch (Exception e)
        {
            logger.info("Scrool To Android Element Failed");
        }
    }


    @Override
    public void touchLongPressAction(int startX, int startY, int endX, int endY, int duration, AppiumDriver driver)
    {
        new TouchAction(driver).longPress(point(startX, startY)).moveTo(point(endX, endY))
                .waitAction(waitOptions(Duration.ofMillis(duration))).release().perform();
    }

    @Override
    public void touchPressAction(int startX, int startY, int endX, int endY, int duration, AppiumDriver driver)
    {
        new TouchAction(driver).press(point(startX, startY)).moveTo(point(endX, endY))
                .waitAction(waitOptions(Duration.ofMillis(duration))).release().perform();
    }

    public void swipeToElement(AppiumDriver driver, MobileElement mobileElement, boolean isClicked)
    {
        swipeToElement(driver, mobileElement, isClicked, false);
    }


}
