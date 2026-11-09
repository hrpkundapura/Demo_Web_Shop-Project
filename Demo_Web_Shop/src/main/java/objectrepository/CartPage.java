
package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    @FindBy(id = "checkout")
    private WebElement checkoutBtn;

    @FindBy(xpath = "//input[@name='removefromcart']")
    private WebElement removeCheckbox;

    @FindBy(xpath = "//input[@name='updatecart']")
    private WebElement updateCartBtn;

    @FindBy(xpath = "//div[@class='order-summary-content']")
    private WebElement emptyCartMsg;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getCheckoutBtn() {
        return checkoutBtn;
    }

    public WebElement getRemoveCheckbox() {
        return removeCheckbox;
    }

    public WebElement getUpdateCartBtn() {
        return updateCartBtn;
    }

    public WebElement getEmptyCartMsg() {
        return emptyCartMsg;
    }
}
