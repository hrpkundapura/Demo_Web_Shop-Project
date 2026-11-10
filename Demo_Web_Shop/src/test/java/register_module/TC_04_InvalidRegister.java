package register_module;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericutility.BaseClass;
import objectrepository.HomePage;
import objectrepository.RegisterPage;
import objectrepository.WelcomePage;

@Listeners(genericutility.ListenerUtility.class)
public class TC_04_InvalidRegister extends BaseClass {

    @Test
    public void invalidRegisterTest() throws IOException {
        // Step 1: Ensure user is logged out before initiating registration
        HomePage hp = new HomePage(driver);
        try {
            if (hp.getLogoutLink().isDisplayed()) {
                hp.getLogoutLink().click();
            }
        } catch (Exception e) {
            // Already logged out
        }

        // Step 2: Navigate to Register page from WelcomePage
        WelcomePage wp = new WelcomePage(driver);
        wutil.waitForElementToBeClickable(driver, wp.getRegisterLink(), 10);
        wp.getRegisterLink().click();

        // Step 3: Fetch existing user credentials from commondata.properties
        String email = futil.getDataFromProperty("email");
        String password = futil.getDataFromProperty("password");

        // Step 4: Fill form with already-registered email
        RegisterPage rp = new RegisterPage(driver);
        wutil.waitForElementToBeClickable(driver, rp.getMaleGenderRadioBtn(), 10);
        rp.getMaleGenderRadioBtn().click();

        rp.getFirstNameTextField().sendKeys("Arrow");
        rp.getLastNameTextField().sendKeys("A");
        rp.getEmailTextField().sendKeys(email);
        rp.getPasswordTextField().sendKeys(password);
        rp.getConfirmPasswordTextField().sendKeys(password);

        // Step 5: Click Register
        rp.getRegisterButton().click();

        // Step 6: Validate "The specified email already exists" message
        wutil.waitForVisibility(driver, rp.getEmailAlreadyExistsErrorMsg(), 10);
        String actualErrorMsg = rp.getEmailAlreadyExistsErrorMsg().getText().trim();
        String expectedErrorMsg = "The specified email already exists";

        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Duplicate email error validation failed!");
    }
}