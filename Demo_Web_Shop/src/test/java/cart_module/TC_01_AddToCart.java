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
public class TC_01_AddToCart extends BaseClass{
	@Test
public void addToCart() throws IOException {
	HomePage h=new HomePage(driver);
	h.getSearchBox().sendKeys(eutil.getStringDataFromExcel("Sheet1", 0, 0)+Keys.ENTER);
	SearchPage s=new SearchPage(driver);
	s.getSmartphoneLink().click();
	DescriptionPage d=new DescriptionPage(driver);
	d.getAddToCartBtn().click();
	String text = d.getPopupMsg().getText();
	Assert.assertEquals(text, "The product has been added to your shopping cart");
	d.getShoppingCartLink().click();
	CartPage c=new CartPage(driver);
	boolean res = c.getCheckoutBtn().isDisplayed();
	Assert.assertTrue(res);
}
}

