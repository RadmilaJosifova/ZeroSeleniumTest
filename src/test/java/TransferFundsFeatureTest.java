import Pages.AccountSummaryPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.TransferFundsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TransferFundsFeatureTest {
    ChromeOptions chromeOptions = new ChromeOptions();
    private LoginPage loginPage;
    private AccountSummaryPage accountSummaryPage;
    private TransferFundsPage transferFundsPage;
    private WebDriver driver;


    @BeforeClass
    public void beforeClass() {
        chromeOptions.addArguments("--allow-insecure-localhost");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--ignore-certificate-errors");

        driver = new ChromeDriver(chromeOptions);
        loginPage = new LoginPage(driver);
        accountSummaryPage = new AccountSummaryPage(driver);
        transferFundsPage = new TransferFundsPage(driver);

        driver.get("http://zero.webappsecurity.com/login.html");

        loginPage.enterUserName();
        loginPage.enterPassword();
        loginPage.logInButton();

        accountSummaryPage.clickTransferFundsButton();

    }



    @Test
    public void transferFundsTest ()  {
        transferFundsPage.clickToAccountDropDown();

        //   driver.wait(1000);
        transferFundsPage.clickToAccountOption();
      //  driver.wait(1000);
        transferFundsPage.fullFieldAmount();
        transferFundsPage.fullFieldDescription();
        transferFundsPage.buttonContinue();

        transferFundsPage.submitButtonForTransferMoneyAndMakePayments();
        String expectedUrlPage = "transfer-funds-verify.html";
        String currentUrlPage = driver.getCurrentUrl();

        boolean correctUrl = currentUrlPage.contains(expectedUrlPage);




    }
   @Test
    public void successSubmitTransaction(){
       transferFundsPage.fullFieldAmount();
       transferFundsPage.fullFieldDescription();
       transferFundsPage.buttonContinue();
       transferFundsPage.submitButtonForTransferMoneyAndMakePayments();

       String expectedUrl2= "transfer-funds-confirm.html";

       String currentUrlPage = driver.getCurrentUrl();

       boolean correctUrl = currentUrlPage.contains(expectedUrl2);


      String expectedMessage = "You successfully submitted your transaction.";

       Assert.assertEquals(transferFundsPage.getTextFieldSucsessfulSubmitedTransaction(),expectedMessage);

        transferFundsPage.finalSavingsGetText();
        String expectedMessage2 ="Savings";
        Assert.assertEquals(transferFundsPage.finalSavingsGetText(),expectedMessage2);

       // transferFundsPage.finalAmountGetText();
     //   String expectedMessage3 ="$ 300";
     //  Assert.assertEquals(transferFundsPage.finalAmountGetText(),expectedMessage2);


   }

     @AfterClass
    public void afterClass() {

      driver.close();
      driver.quit();
  }
}