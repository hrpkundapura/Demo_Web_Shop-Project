package books;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericutility.BaseClass;
import objectrepository.HomePage;

@Listeners(genericutility.ListenerUtility.class)
public class TC_DWS_001_Test extends BaseClass {
	@Test
	public void clickOnBooks() {

		HomePage hp = new HomePage(driver);
		hp.getBooksLink().click();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Books", "Books page is not displayed");

	}

}
