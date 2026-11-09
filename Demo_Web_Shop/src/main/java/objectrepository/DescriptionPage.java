package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DescriptionPage {
	@FindBy(xpath  = "(//input[@value='Add to cart'])[1]")
	private WebElement addToCartBtn;

	@FindBy(className = "content")
	private WebElement popupMsg;

	@FindBy(xpath  = "//span[text()='Shopping cart']")
	private WebElement shoppingCartLink;
	
	public DescriptionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddToCartBtn() {
		return addToCartBtn;
	}

	public WebElement getPopupMsg() {
		return popupMsg;
	}

	public WebElement getShoppingCartLink() {
		return shoppingCartLink;
	}
	
}
