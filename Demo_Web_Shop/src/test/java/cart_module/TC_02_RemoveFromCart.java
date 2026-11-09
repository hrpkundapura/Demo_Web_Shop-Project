
package cart_module;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericutility.BaseClass;
import objectrepository.CartPage;
import objectrepository.DescriptionPage;
import objectrepository.HomePage;
import objectrepository.SearchPage;

@Listeners(genericutility.ListenerUtility.class)
public class TC_02_RemoveFromCart extends BaseClass {

    @Test
    public void removeFromCart() throws IOException {

        // Step 1: Create HomePage object
        HomePage h = new HomePage(driver);

        // Step 2: Search product using Excel data
        h.getSearchBox().sendKeys(
            eutil.getStringDataFromExcel("Sheet1", 0, 0) + Keys.ENTER
        );

        // Step 3: Create SearchPage object
        SearchPage s = new SearchPage(driver);

        // Step 4: Click Smartphone link
        s.getSmartphoneLink().click();

        // Step 5: Create DescriptionPage object
        DescriptionPage d = new DescriptionPage(driver);

        // Step 6: Click Add to Cart
        d.getAddToCartBtn().click();

        // Step 7: Verify popup message
        String text = d.getPopupMsg().getText();

        Assert.assertEquals(
            text,
            "The product has been added to your shopping cart"
        );

        // Step 8: Navigate to Shopping Cart
        d.getShoppingCartLink().click();

        // Step 9: Create CartPage object
        CartPage c = new CartPage(driver);

        // Step 10: Select Remove checkbox
        c.getRemoveCheckbox().click();

        // Step 11: Click Update Shopping Cart
        c.getUpdateCartBtn().click();

        // Step 12: Verify product is removed
        boolean result = driver.getPageSource()
                .contains("Your Shopping Cart is empty!");

        Assert.assertTrue(
            result,
            "Product is not removed from Shopping Cart"
        );
    }
}
