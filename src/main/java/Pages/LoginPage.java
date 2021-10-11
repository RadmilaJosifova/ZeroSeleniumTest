package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(className="page-header")
    private WebElement header;

    @FindBy(css="input[name=\"user_login\"")
    private WebElement userLoginIn;

    @FindBy(css = "input[name=\"user_password\"")
    private WebElement userPassword;

    @FindBy(css = "input[value=\"Sign in\"]")
    private WebElement buttonSingIn;

    @FindBy(css ="div[class=\"alert alert-error\"]")
    private WebElement invalidLogIn;

    public boolean isHeaderDisplayed(){
        return header.isDisplayed();

    }
    public String getText(){
        return header.getText();
    }
    public void enterUserName(){
        userLoginIn.sendKeys("username");
    }
    public void enterPassword(){
        userPassword.sendKeys("password");
    }

    public void logInButton(){
        buttonSingIn.click();
    }
    public String invalidLoginInGetText(){
        return invalidLogIn.getText();
    }
}