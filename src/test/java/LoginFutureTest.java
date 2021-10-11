import Pages.AccountSummaryPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginFutureTest{
    ChromeOptions chromeOptions = new ChromeOptions();
    private HomePage homePage ;
    private LoginPage loginPage;
    private AccountSummaryPage accountSummaryPage;
    private WebDriver driver;

    public static String ExpectedHeaderString = "Log in to Zero Bank";

    @BeforeClass
    public void beforeClass(){
        chromeOptions.addArguments("--allow-insecure-localhost");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--ignore-certificate-errors");

        driver = new ChromeDriver(chromeOptions);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        accountSummaryPage = new AccountSummaryPage(driver);

        driver.get("http://zero.webappsecurity.com/login.html");

    }
    @Test
    public void invalidLoginTest() {
        loginPage.logInButton();
        String expectedMessage = "Login and/or password are wrong.";
        Assert.assertEquals(loginPage.invalidLoginInGetText(),expectedMessage);

    }

    @Test
    public  void successfullyLoginTest() {

        loginPage.enterUserName();
        loginPage.enterPassword();
        loginPage.logInButton();
        String expectedUrl = "account-summary.html";
        String currentUrl = driver.getCurrentUrl();
        boolean isCorrectUrl = currentUrl.contains(expectedUrl);
        Assert.assertTrue(isCorrectUrl);
//  accountSummaryPage.getText();

    }
    @AfterClass
            public void afterClass(){

        driver.close();
        driver.quit();
    }

    }

