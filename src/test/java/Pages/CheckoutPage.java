package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    @FindBy(id = "first-name")
    WebElement firstNameInput;
    @FindBy(id = "last-name")
    WebElement lastNameInput;
    @FindBy(id = "postal-code")
    WebElement postalCodeInput;
    @FindBy(name = "continue")
    WebElement continueButton;
    @FindBy(xpath = "//span[text() = 'Checkout: Overview']")
    WebElement overviewTitle;
    @FindBy(xpath = "//input[@placeholder = 'Zip/Postal Code']")
    WebElement postalCodeErrorMessage;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void setYourInformationInput(String firstName, String lastName, String postalCode) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        postalCodeInput.sendKeys(postalCode);
    }

    public void setFirstNameInput(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void setLastNameInput(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public boolean isOverviewTitleDisplayed() {
        return overviewTitle.isDisplayed();
    }

    public boolean isPostalCodeErrorMessageDisplayed() {
        return postalCodeErrorMessage.isDisplayed();
    }
}
