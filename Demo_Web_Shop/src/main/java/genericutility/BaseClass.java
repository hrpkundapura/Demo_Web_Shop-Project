package genericutility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import objectrepository.HomePage;
import objectrepository.LoginPage;
import objectrepository.WelcomePage;

public class BaseClass {
	public static WebDriver driver;
	public WebdriverUtility wutil = new WebdriverUtility();
	public FileUtility futil = new FileUtility();
	public ExcelUtility eutil = new ExcelUtility();

	@BeforeClass
	public void openBrowser() throws IOException {
		driver = new ChromeDriver();
		wutil.maximize(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(futil.getDataFromProperty("url"));
	}

	@BeforeMethod
	public void login() throws IOException {
		WelcomePage wp = new WelcomePage(driver);
		wp.getLoginLink().click();
		//driver.findElement(By.className("ico-login")).click();
		LoginPage lp = new LoginPage(driver);
		lp.getEmailTextField().sendKeys(futil.getDataFromProperty("email"));
		lp.getPasswordTextField().sendKeys(futil.getDataFromProperty("password"));
		lp.getLoginButton().click();

	}

	@AfterMethod
	public void logout() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		Thread.sleep(2000);
		hp.getLogoutLink().click();
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}
