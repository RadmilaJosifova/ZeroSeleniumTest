package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TransferFundsPage extends BasePage {
    public TransferFundsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "tf_fromAccountId")
    WebElement toAccountDropDown;

    @FindBy(css = "select[id=\"tf_toAccountId\"]>option[value=\"3\"]")
    WebElement toAccountDropDownOptionSecondSavings;

    @FindBy(css = "input[name=\"amount\"")
    WebElement amount;

    @FindBy(css = "input[class=\"input-xlarge\"]")
    WebElement description;


    @FindBy(css = "button[class=\"btn btn-primary\"]")
    WebElement buttonContinue;

    @FindBy(css = "button[id=\"btn_submit\"]")
    WebElement buttonSubmit;

    @FindBy(css = "div[class=\"alert alert-success\"]")
    WebElement getText;

    @FindBy(css = "div[class=\"row\"]>div[class=\"span3\"]")
    List<WebElement> results;


    public void clickToAccountDropDown() {
        toAccountDropDown.click();
    }

    public void clickToAccountOption() {
        toAccountDropDownOptionSecondSavings.click();
    }

    public void fullFieldAmount() {
        amount.sendKeys("300");
    }

    public void fullFieldDescription() {
        clearAndSendKeys(description,"prefrli");
    }

    public void buttonContinue() {
    waitForElementToBeClickableAndClick(buttonContinue);    }

    public void submitButtonForTransferMoneyAndMakePayments() {
        buttonSubmit.click();
    }

    public String submitButtonText() {
        return buttonSubmit.getText();

    }

    public String getTextFieldSucsessfulSubmitedTransaction() {
        return getText.getText();
    }

    public String fromAccountText() {
        return results.get(0).getText();
    }

    public String toAccountText() {
        return results.get(1).getText();
    }

    public String amountText() {
        return results.get(2).getText();
    }
}