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
public class TC_03_Register extends BaseClass {

    @Test
    public void registerTest() throws IOException {
        // Step 1: Ensure browser is logged out before starting registration
        HomePage hp = new HomePage(driver);
        try {
            if (hp.getLogoutLink().isDisplayed()) {
                hp.getLogoutLink().click();
            }
        } catch (Exception e) {
            // Already in logged-out state
        }

        // Step 2: Click 'Register' link from WelcomePage
        WelcomePage wp = new WelcomePage(driver);
        wutil.waitForElementToBeClickable(driver, wp.getRegisterLink(), 10);
        wp.getRegisterLink().click();

        // Step 3: Fetch test data from Sheet2 (Row 1)
        String gender    = eutil.getStringDataFromExcel("Sheet2", 1, 0); // Male
        String firstName = eutil.getStringDataFromExcel("Sheet2", 1, 1); // Brew
        String lastName  = eutil.getStringDataFromExcel("Sheet2", 1, 2); // Bee
        String email     = eutil.getStringDataFromExcel("Sheet2", 1, 3); // brewbee@email.com
        String password  = eutil.getStringDataFromExcel("Sheet2", 1, 4); // BrewBee@123

        // Step 4: Populate registration form
        RegisterPage rp = new RegisterPage(driver);

        // Select gender dynamically based on Excel
        if (gender.equalsIgnoreCase("male")) {
            wutil.waitForElementToBeClickable(driver, rp.getMaleGenderRadioBtn(), 10);
            rp.getMaleGenderRadioBtn().click();
        } else if (gender.equalsIgnoreCase("female")) {
            wutil.waitForElementToBeClickable(driver, rp.getFemaleGenderRadioBtn(), 10);
            rp.getFemaleGenderRadioBtn().click();
        }

        rp.getFirstNameTextField().sendKeys(firstName);
        rp.getLastNameTextField().sendKeys(lastName);
        rp.getEmailTextField().sendKeys(email);

        // Enter the same Pwd into Password and ConfirmPassword
        rp.getPasswordTextField().sendKeys(password);
        rp.getConfirmPasswordTextField().sendKeys(password);

        // Step 5: Submit form
        rp.getRegisterButton().click();

        // Step 6: Verify registration outcome
        wutil.waitForVisibility(driver, rp.getRegistrationSuccessMessage(), 10);
        String actualMessage = rp.getRegistrationSuccessMessage().getText().trim();
        String expectedMessage = "Your registration completed";

        Assert.assertEquals(actualMessage, expectedMessage, "Registration failed or confirmation text mismatch!");
    }
}