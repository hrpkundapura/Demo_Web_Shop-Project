package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    // Gender radio buttons
    @FindBy(id = "gender-male")
    private WebElement maleGenderRadioBtn;

    @FindBy(id = "gender-female")
    private WebElement femaleGenderRadioBtn;

    // Text fields
    @FindBy(id = "FirstName")
    private WebElement firstNameTextField;

    @FindBy(id = "LastName")
    private WebElement lastNameTextField;

    @FindBy(id = "Email")
    private WebElement emailTextField;

    @FindBy(id = "Password")
    private WebElement passwordTextField;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordTextField;

    // Register button
    @FindBy(id = "register-button")
    private WebElement registerButton;

    // Success confirmation text
    @FindBy(xpath = "//div[@class='result']")
    private WebElement registrationSuccessMessage;

    // Error message: "The specified email already exists"
    @FindBy(xpath = "//div[@class='validation-summary-errors']//li")
    private WebElement emailAlreadyExistsErrorMsg;

    // Constructor
    public RegisterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Getters
    public WebElement getMaleGenderRadioBtn() {
        return maleGenderRadioBtn;
    }

    public WebElement getFemaleGenderRadioBtn() {
        return femaleGenderRadioBtn;
    }

    public WebElement getFirstNameTextField() {
        return firstNameTextField;
    }

    public WebElement getLastNameTextField() {
        return lastNameTextField;
    }

    public WebElement getEmailTextField() {
        return emailTextField;
    }

    public WebElement getPasswordTextField() {
        return passwordTextField;
    }

    public WebElement getConfirmPasswordTextField() {
        return confirmPasswordTextField;
    }

    public WebElement getRegisterButton() {
        return registerButton;
    }

    public WebElement getRegistrationSuccessMessage() {
        return registrationSuccessMessage;
    }

    public WebElement getEmailAlreadyExistsErrorMsg() {
        return emailAlreadyExistsErrorMsg;
    }
}