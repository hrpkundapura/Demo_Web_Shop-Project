package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	@FindBy(xpath= "//a[text()='Smartphone']")
	private WebElement smartphoneLink;
	
	public SearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSmartphoneLink() {
		return smartphoneLink;
	}
}
