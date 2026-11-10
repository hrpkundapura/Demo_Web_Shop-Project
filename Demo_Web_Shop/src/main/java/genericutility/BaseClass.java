package genericutility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import objectrepository.HomePage;
import objectrepository.LoginPage;
import objectrepository.WelcomePage;

public class BaseClass {

    public WebDriver driver;
    public static WebDriver sdriver;

    public FileUtility futil = new FileUtility();
    public ExcelUtility eutil = new ExcelUtility();
    public WebdriverUtility wutil = new WebdriverUtility();

    @BeforeClass(alwaysRun = true)
    public void openBrowser() throws IOException {
        String browser = futil.getDataFromProperty("browser");
        String url = futil.getDataFromProperty("url");

        if (browser != null && browser.trim().equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        } else if (browser != null && browser.trim().equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser != null && browser.trim().equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
        }

        sdriver = driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
    }

    @BeforeMethod(alwaysRun = true)
    public void login() throws IOException {
        WelcomePage wp = new WelcomePage(driver);
        wp.getLoginLink().click();

        LoginPage lp = new LoginPage(driver);
        lp.getEmailTextField().sendKeys(futil.getDataFromProperty("email"));
        lp.getPasswordTextField().sendKeys(futil.getDataFromProperty("password"));
        lp.getLoginButton().click();
    }

    @AfterMethod(alwaysRun = true)
    public void logout() {
        try {
            HomePage hp = new HomePage(driver);
            if (hp.getLogoutLink().isDisplayed()) {
                hp.getLogoutLink().click();
            }
        } catch (Exception e) {
            // Unauthenticated state (e.g., Register tests) - safely ignored
        }
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}