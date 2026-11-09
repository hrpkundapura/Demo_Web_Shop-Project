package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	@FindBy(id = "checkout")
	private WebElement checkoutBtn;
	
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCheckoutBtn() {
		return checkoutBtn;
	}
}
