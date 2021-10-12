package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    @FindBy(css = "div[class=\"span3\"]")
    WebElement finalSavings;

    @FindBy(css = "div[class=\"span3\"]>div>div")
    WebElement finalAmount;

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
        description.sendKeys("prefrli");
    }

    public void buttonContinue() {
        buttonContinue.click();
    }

    public void submitButtonForTransferMoneyAndMakePayments() {
        buttonSubmit.click();
    }

    public String submitButtonText() {
        return buttonSubmit.getText();

    }

    public String getTextFieldSucsessfulSubmitedTransaction() {
        return getText.getText();
    }

    public String finalSavingsGetText() {
        return finalSavings.getText();
    }

    public String finalAmountGetText() {
        return finalAmount.getText();
    }
}