import base.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class NoBrokerTest extends Base {
    AndroidDriver<AndroidElement> driver;

    @BeforeTest
    public void initialization() throws IOException {
        driver=capabilities("NoBrokerApp");
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
    }

    @Test
    public void loginToNoBrokerApp() throws FileNotFoundException {
        Properties prop = null;
        try ( FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/global.properties") ) {
            prop = new Properties();
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String phoneNumber=(String) prop.get("PhoneNumber");
        String password=(String) prop.get("Password");

        new LoginPage(driver).clickOnNavigateUpButton();
        new LoginPage(driver).navigateToLoginPage();
        new LoginPage(driver).inputPhoneNumber(phoneNumber);
        new LoginPage(driver).selectPasswordOption();
        new LoginPage(driver).inputPassword(password);
        new LoginPage(driver).clickContinueToLogin();
        Assert.assertEquals(new HomePage(driver).getHomePageTitle(),
                "World's Largest NoBrokerage Property Site",
                "Login isn't successful");

    }

    @Test
    public void SelectCityAndLocalities(){
        new HomePage(driver).tapOnBuyTab();
        new HomePage(driver).tapOnSearchHomefromSearchField();
        new BuyPage(driver).selectCity("Bangalore");
        new BuyPage(driver).selectLocality("Marathahalli");
        new BuyPage(driver).selectLocality("HSR Layout");

    }

    @Test
    public void selectTwoAndThreeBHKBedroomAndIncludeNearbyProperty(){
        new BuyPage(driver).selectIncludeNearbyProperties();
        new BuyPage(driver).selectTwoBhk();
        new BuyPage(driver).selectThreeBhk();
        new BuyPage(driver).clickOnSearch();
        Assert.assertTrue(new PropertyPage(driver).isSearchBarPreviewAvailable(),
                "Can't search the property");
    }

    @Test
    public void selectPropertyAndReportProperty(){
        for(int i=0;i<=3;i++){
            new PropertyPage(driver).scrollToFourthPropertyAndSelect();
        }
        new PropertyPage(driver).scrollAndSelectWrongInfoOption();
        new PropertyPage(driver).selectAllCheckboxesOfWhatsWrongAndReport();
    }

    @Test
    public void editConfigurationAndSaveChanges(){
        new EditPage(driver).changeBHKType("4+ BHK");
        new EditPage(driver).addNote();
        new EditPage(driver).saveChanges();
        Assert.assertTrue(new EditPage(driver).isFeedbackCompleted(),
                "Feedback is not completed");
        driver.closeApp();
    }

    @AfterTest
    public void closeSession(){
        driver.quit();
    }
}
