package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    @FindBy(id = "first-name")
    WebElement firstName;
    @FindBy(id = "last-name")
    WebElement lastName;
    @FindBy(id = "postal-code")
    WebElement postalCode;
    @FindBy(id = "continue")
    WebElement continueButton;
    @FindBy(xpath = "//span[text() = 'Checkout: Overview']")
    WebElement overviewTitle;
    @FindBy(xpath = "//input[@placeholder = 'Zip/Postal Code']")
    WebElement postalCodeErrorMessage;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void setYourInformationInput() {
        firstName.sendKeys("Ivan");
        lastName.sendKeys("Kovalevsky");
        postalCode.sendKeys("12345");
    }

    public void setFirstNameInput() {
        firstName.sendKeys("Ivan");
    }

    public void setLastNameInput() {
        lastName.sendKeys("Kovalevsky");
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
