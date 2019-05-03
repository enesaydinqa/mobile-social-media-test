package com.appium.mobile.test.facebook;

import com.annotation.Author;
import com.annotation.Contact;
import com.appium.context.Events;
import com.appium.context.app.FacebookAndroidTest;
import com.appium.pages.SearchPage;
import com.appium.pages.facebook.HomePage;
import com.appium.pages.facebook.LoginPage;
import com.appium.pages.facebook.SharePage;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static com.appium.utils.ReportInformation.*;

public class FacebookSingleDeviceTest extends FacebookAndroidTest {

    private Logger logger = Logger.getLogger(FacebookSingleDeviceTest.class);

    private LoginPage loginPage;
    private HomePage homePage;
    private SharePage sharePage;
    private SearchPage searchPage;


    @Before
    public void init() throws Exception
    {
        super.init();

        loginPage = new LoginPage(firstMobile);
        homePage = new HomePage(firstMobile);
        sharePage = new SharePage(firstMobile);
        searchPage = new SearchPage(firstMobile);
    }

    @Test
    @Contact(Author.SELIM)
    public void testPhotoShare() throws InterruptedException, IOException {
        //loginFacebook(firstMobile, "mskoc@enerjim-muhendislik.com", "mobicom1234");
        //LoginPage loginPageF = new LoginPage(firstMobile);
        //sleep(20);
        logger.info("test started");
        //waitAndClick(firstMobile, loginPageF.loginButton);
//        waitAndClearInput(loginPageF.userName);
//        waitAndSendKeys(firstMobile, loginPageF.userName, "mskoc@enerjim-muhendislik.com");
//        waitAndClearInput(loginPageF.password);
//        waitAndSendKeys(firstMobile, loginPageF.password, "mobicom1234");
//        waitAndClick(firstMobile, loginPageF.loginButton);


        waitAndClick(firstMobile, loginPage.selectUser);
        //waitNotVisible(firstMobile, homePage.locationPermissionBy);
        waitAndClick(firstMobile, homePage.photoButton);
        //waitNotVisible(firstMobile, homePage.photoPermission);
        waitAndClick(firstMobile, sharePage.photoSelect);
        waitAndClick(firstMobile, sharePage.nextButton);
        waitAndClick(firstMobile, sharePage.shareButton);
        waitNotVisible(firstMobile, sharePage.newsFeedRadioButtonNotSelected);
        waitNotVisible(firstMobile, sharePage.yourStoryRadioButtonSelected);
        waitAndClick(firstMobile, sharePage.shareNowButton);
        sleep(10);
    }

    @Test
    @Contact(Author.SELIM)
    public void testVideoShare() throws InterruptedException, IOException {

        waitAndClick(firstMobile, loginPage.selectUser);
        //waitNotVisible(firstMobile, homePage.locationPermissionBy);
        waitAndClick(firstMobile, homePage.photoButton);
        //waitNotVisible(firstMobile, homePage.photoPermission);
        waitAndClick(firstMobile, sharePage.videoSelect);
        //waitAndClick(firstMobile, sharePage.videoSelect2);
        waitAndClick(firstMobile, sharePage.nextButton);
        waitAndClick(firstMobile, sharePage.shareButton);
        waitAndClick(firstMobile, sharePage.shareNowButton);
        waitElementVisible(firstMobile, sharePage.useDataPermissions);
        waitAndClick(firstMobile, sharePage.useDataPermissions);

        sleep(10);
    }

    @Test
    @Contact(Author.SELIM)
    public void testStoryShare() throws InterruptedException, IOException {

        waitAndClick(firstMobile, loginPage.selectUser);
        //waitNotVisible(firstMobile, homePage.locationPermissionBy);
        waitAndClick(firstMobile, homePage.photoButton);
        //waitNotVisible(firstMobile, homePage.photoPermission);
        waitAndClick(firstMobile, sharePage.videoSelect);
        waitAndClick(firstMobile, sharePage.nextButton);
        waitAndClick(firstMobile, sharePage.shareButton);
        waitAndClick(firstMobile, sharePage.newsFeedRadioButtonSelected);
        waitAndClick(firstMobile, sharePage.yourStoryRadioButtonNotSelected);

//        if(homePage.shareLayout.findElement(homePage.newsFeedRadioButtonNotSelected) != null){
//            logger.info("dışarda");
//        }

        waitAndClick(firstMobile, sharePage.shareNowButton);
        waitElementVisible(firstMobile, sharePage.useDataPermissions);
        waitAndClick(firstMobile, sharePage.useDataPermissions);
        sleep(10);
    }

    @Test
    @Contact(Author.SELIM)
    public void testShareText() throws InterruptedException {
        //sleep(30);
        waitAndClick(firstMobile, loginPage.selectUser);
        waitAndClick(firstMobile, homePage.shareTextClick);
        //waitAndClick(firstMobile, homePage.shareText);
        waitAndSendKeys(firstMobile, sharePage.shareEditText,"Bu bir deneme mesajıdır.");
        waitAndClick(firstMobile, sharePage.shareButton);
        waitAndClick(firstMobile, sharePage.shareNowButton);
        sleep(10);
    }

    @Test
    @Contact(Author.SELIM)
    public void testAddFriend() throws InterruptedException {

//        waitAndClick(firstMobile, loginPage.selectUser);
//        waitAndClick(firstMobile, searchPage.searchTextClick);
//        waitAndSendKeys(firstMobile, searchPage.searchText, "Rüştü Reçber");
//        //waitAndSendKeys(firstMobile, searchPage.searchTextClick, "Rüştü Reçber");
//        waitAndClick(firstMobile, searchPage.selectSearchUser);
//        waitAndClick(firstMobile, searchPage.selectSearchUserAddFriend);



        waitAndClick(firstMobile, loginPage.selectUser);
        waitAndClick(firstMobile, homePage.selectBar);
        waitAndClick(firstMobile, searchPage.findFriends);
        waitAndClick(firstMobile, searchPage.searchButton);
        waitAndSendKeys(firstMobile, searchPage.searchByNameText, "Rüştü Reçber");
        waitAndClick(firstMobile, searchPage.addFriendButton);
        sleep(10);
    }

    @Test
    @Contact(Author.SELIM)
    public void testLike() throws InterruptedException {

        //ileride sıkıntı çıkmaması için gönderi paylaşıp daha sonra beğen ve yorum yapma işlemi yapmak daha sağlıklı olabilir!
        waitAndClick(firstMobile, loginPage.selectUser);
        swipeScreen(firstMobile, SwipeDirection.UP, 3);
        //swipeToElement(firstMobile, homePage.likeButton, true, false);

        swipeScreen(firstMobile, SwipeDirection.DOWN, 3);
        try{
            Assert.assertTrue(homePage.likeButton.isDisplayed());
            waitAndClick(firstMobile, homePage.likeButton);
        }
        catch (Exception e){
            Assert.assertTrue(homePage.dontLikeButton.isDisplayed());
            waitAndClick(firstMobile, homePage.dontLikeButton);
        }
        sleep(5);
    }

    @Test
    @Contact(Author.SELIM)
    public void testComment() throws InterruptedException {

        waitAndClick(firstMobile, loginPage.selectUser);
        swipeScreen(firstMobile, SwipeDirection.UP, 3);
        swipeScreen(firstMobile, SwipeDirection.DOWN, 3);
        //swipeToElement(firstMobile, homePage.commentButton, true, false); ////Gönderi alt sıralarda kalınca sayfayı baya aşağı inderecek performans sıkıntısı olabilir!
        waitAndClick(firstMobile, homePage.commentButton);
        waitAndSendKeys(firstMobile, homePage.commentWriteText, "Çok güzel bir gönderi, bravo!");
        waitAndClick(firstMobile, homePage.commentSendMessageButton);
        sleep(5);
    }
}
