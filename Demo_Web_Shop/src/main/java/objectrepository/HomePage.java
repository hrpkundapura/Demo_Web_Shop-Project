package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(linkText = "Log out")
	private WebElement logoutLink;
	
	@FindBy(partialLinkText = "BOOKS")
	private WebElement booksLink;

	@FindBy(partialLinkText = "COMPUTERS")
	private WebElement computersLink;

	@FindBy(partialLinkText = "ELECTRONICS")
	private WebElement electronicsLink;
	
	@FindBy(id = "small-searchterms")
	private WebElement searchBox;
	
	@FindBy(partialLinkText = "GIFT CARDS")
	private WebElement giftCardsLink;
	
	@FindBy(partialLinkText = "Desktops")
	private WebElement desktopsLink;
	
	@FindBy(id = "products-orderby")
	private WebElement positionDropdown;
	
	
	

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public WebElement getBooksLink() {
		return booksLink;
	}

	public WebElement getComputersLink() {
		return computersLink;
	}

	public WebElement getElectronicsLink() {
		return electronicsLink;
	}

	public WebElement getGiftCardsLink() {
		return giftCardsLink;
	}

	public WebElement getDesktopsLink() {
		return desktopsLink;
	}

	public WebElement getPositionDropdown() {
		return positionDropdown;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	

	

	
	

}
