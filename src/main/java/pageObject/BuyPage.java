package pageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BuyPage extends BasePage{

    @AndroidFindBy(id="spinnergo")
    private AndroidElement cityDropdown;

    @AndroidFindBy(id="localityAutoCompleteTxt")
    private AndroidElement localitySearchBar;

    @AndroidFindBy(id = "fl_multiple_locations")
    private AndroidElement localityNameBySearch;

    @AndroidFindBy(id = "nearByRadio")
    private AndroidElement nearByRadioButton;

    @AndroidFindBy(id = "bhktwo")
    private AndroidElement twoBhk;

    @AndroidFindBy(id = "bhkthree")
    private AndroidElement threeBhk;

    @AndroidFindBy(id = "searchProperty")
    private AndroidElement searchPropertyButton;


    public BuyPage(AndroidDriver<AndroidElement> driver){
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public void selectCity(String cityName){
        WebElement city= driver.findElementByXPath(String.format("//android.widget.TextView[@text='%s']",cityName));
        city.click();
    }

    public void selectLocality(String localityName){
        localitySearchBar.click();
        localitySearchBar.sendKeys(localityName);
        localityNameBySearch.click();

    }

    public void selectIncludeNearbyProperties(){
        if(!nearByRadioButton.isSelected()){
            nearByRadioButton.click();
        }
    }

    public void selectTwoBhk(){
        twoBhk.click();
    }

    public void selectThreeBhk(){
        threeBhk.click();
    }

    public void clickOnSearch(){
        searchPropertyButton.click();
    }
}
