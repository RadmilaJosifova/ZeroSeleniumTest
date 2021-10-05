import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.lang.module.Configuration;

public class LoginFutureTest {

    private static final WebDriver driver = new ChromeDriver();
    static HomePage homePage = new HomePage();

    @Test
    public static void successfullyLoginTest(){

        driver.get("http://zero.webappsecurity.com/index.html");
        homePage.clickElement();
        driver.quit();
    }

    }

