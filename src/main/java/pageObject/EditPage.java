package pageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class EditPage extends BasePage{

    @AndroidFindBy(id = "rl_bhk_type_container")
    private AndroidElement selectBhKType;

    @AndroidFindBy(id = "btn_save")
    private AndroidElement saveButton;

    @AndroidFindBy(id = "edt_others")
    private AndroidElement addNoteField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Thank you for the feedback']")
    private AndroidElement feedbackMessage;


    public EditPage(AndroidDriver<AndroidElement> driver){
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public void changeBHKType(String newBHK){
        selectBhKType.click();
        WebElement changedBHK= driver.findElementByXPath(String.format("//android.widget.TextView[@text='%s']",newBHK));
        changedBHK.click();
    }

    public void addNote(){
        scrollToText("Add a note");
        addNoteField.click();
        addNoteField.sendKeys("Test Message");
    }

    public void saveChanges(){
        saveButton.click();
    }

    public boolean isFeedbackCompleted(){
        return feedbackMessage.isDisplayed();
    }
}
