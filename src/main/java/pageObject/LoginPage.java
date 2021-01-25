package pageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    private AndroidElement navigateButton;

    @AndroidFindBy(id="imgUserPic")
    private AndroidElement loginImage;

    @AndroidFindBy(className = "android.widget.EditText")
    private AndroidElement enterPhoneNumberField;

    @AndroidFindBy(id = "rb_signup_pwd")
    private AndroidElement passwordRadioButton;

    @AndroidFindBy(id = "et_sigup_pwd")
    private AndroidElement enterPasswordField;

    @AndroidFindBy(id = "btn_signup")
    private AndroidElement continueButton;

    public LoginPage(AndroidDriver<AndroidElement> driver){
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public void clickOnNavigateUpButton(){
        waitForElementToBeClickable(navigateButton);
        navigateButton.click();

    }

    public void navigateToLoginPage(){
        waitForElementToBeVisible(loginImage);
        loginImage.click();
    }

    public void inputPhoneNumber(String phonenNumber){
        enterPhoneNumberField.click();
        enterPhoneNumberField.sendKeys(phonenNumber);
    }

    public void selectPasswordOption(){
        waitForElementToBeClickable(passwordRadioButton);
        passwordRadioButton.click();
    }

    public void inputPassword(String password){
        enterPasswordField.click();
        enterPasswordField.sendKeys(password);
    }

    public void clickContinueToLogin(){
        continueButton.click();
    }

}
