package pageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
    @AndroidFindBy(id="homeTitle")
    private AndroidElement homeTitle;

    @AndroidFindBy(id = "buyLayoutText")
    private AndroidElement buyTab;

    @AndroidFindBy(id="searchEditHome")
    private AndroidElement searchHomeField;

    public HomePage(AndroidDriver<AndroidElement> driver){
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public String getHomePageTitle(){
        waitForElementToBeVisible(homeTitle);
        return homeTitle.getText();
    }

    public void tapOnBuyTab(){
        waitForElementToBeVisible(buyTab);
        buyTab.click();
    }

    public void tapOnSearchHomefromSearchField(){
        waitForElementToBeClickable(searchHomeField);
        searchHomeField.click();
    }

}
