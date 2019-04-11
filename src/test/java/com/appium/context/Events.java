package com.appium.context;

import com.appium.client.date.DateFormatType;
import com.appium.mobile.CommonMobile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class Events implements CommonMobile
{
    private Logger logger = Logger.getLogger(Events.class);

    @Override
    public void waitAndClick(AppiumDriver driver, MobileElement element)
    {
        waitAndClick(driver, element, false, null);
    }

    public void waitAndClick(AppiumDriver driver, MobileElement element, Boolean log, String description)
    {
        try
        {
            waitElementToBeClickable(driver, element);
            element.click();
            sleep(1);

            if (log)
            {
                logger.info(description + " : " + getCurrentDate(DateFormatType.FULL_DATE.dateFormat));
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void WaitAndSendKeys(AppiumDriver driver, MobileElement element, String Text)
    {
        waitElementVisible(driver, element);
        element.sendKeys(Text);
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
    public String getGeoLocation() throws IOException, InterruptedException
    {
        Process proc = Runtime.getRuntime().exec(String.format("adb shell dumpsys location"));

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

    public void waitElementVisible(AppiumDriver driver, MobileElement element, Boolean log, String description)
    {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(element));

        if (log)
        {
            logger.info(description + " : " + getCurrentDate(DateFormatType.FULL_DATE.dateFormat));
        }
    }

    public void waitNotVisible(AppiumDriver driver, By element, Boolean log, String description)
    {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(element));

        if (log)
        {
            logger.info(description + " : " + getCurrentDate(DateFormatType.FULL_DATE.dateFormat));
        }
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

    public void pushFileMobile(AppiumDriver driver, String mobilePath, String projectFilePath)
    {
        try
        {
            String file = System.getProperty("user.dir").concat(projectFilePath);

            ((AndroidDriver) driver).pushFile(mobilePath, new File(file));

            logger.info("=============================================================================================");
            logger.info(String.format("==> Successfull Push File Mobile : %s", mobilePath));
            logger.info("=============================================================================================");
        }
        catch (Exception ex)
        {
            logger.info("Not Successfull Push File Mobile");
        }
    }

}