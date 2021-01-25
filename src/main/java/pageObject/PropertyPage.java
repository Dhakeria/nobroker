package pageObject;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class PropertyPage extends BasePage {
    @AndroidFindBy(id="searchPreview")
    private AndroidElement searchBarPreview;

    @AndroidFindBy(id = "tv_report_wrong_info")
    private AndroidElement wrongInfoOption;

    @AndroidFindBy(id = "btn_report")
    private AndroidElement reportButton;

    @AndroidFindBy( id = "property_item_shortlist")
    private AndroidElement shortlistfield;


    public PropertyPage(AndroidDriver<AndroidElement> driver){
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public boolean isSearchBarPreviewAvailable(){
        return searchBarPreview.isDisplayed();
    }

    public void scrollToFourthPropertyAndSelect(){
        try {
            int x = 100;
            int y = 250;
            int y1 = y-150;

            swipe(x, y, x, y1);
        } catch(Exception e) {

            System.out.println(e.getMessage());
        }

        waitForElementToBeVisible(shortlistfield);
        shortlistfield.click();

    }
    public void swipe(int fromX,int fromY,int toX,int toY) {

        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(fromX,fromY))
                .waitAction(new WaitOptions().withDuration(Duration.ofMillis(10000)))
                .moveTo(PointOption.point(toX, toY))
                .waitAction(new WaitOptions().withDuration(Duration.ofMillis(10000)))
                .release()
                .perform();
    }



    public void scrollAndSelectWrongInfoOption(){
        scrollToResourceId("tv_report_wrong_info");
        wrongInfoOption.click();
    }

    public void selectAllCheckboxesOfWhatsWrongAndReport(){
        waitForElementToBeVisible(reportButton);
        List<WebElement> elements = driver.findElements(By.xpath("//android.widget.CheckBox"));
        for(WebElement element: elements){
            element.click();
        }

        reportButton.click();

    }
}
