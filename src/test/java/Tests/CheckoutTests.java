package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTests {

    @Test(description = "Checking the transition to the checkout page",
            groups = {"smoke"})
    public void checkoutInputTest() {
        loginPage.initialization(USER_NAME, PASSWORD);
        productsPage.clickAddToCartButton(SAUCE_LABS_BACKPACK);
        headerPage.shoppingCartButtonClick();
        shoppingCartPage.clickCheckoutButton();
        checkoutPage.setYourInformationInput(CHECKOUT_FIRST_NAME, CHECKOUT_LAST_NAME, CHECKOUT_POSTAL_CODE);
        checkoutPage.clickContinueButton();
        Assert.assertTrue(checkoutPage.isOverviewTitleDisplayed());
    }

    @Test(description = "Checking for incomplete information entered on the 'CHECKOUT: YOUR INFORMATION' page",
            groups = {"negative", "regression"})
    public void checkoutInputNegativeTest() {
        loginPage.initialization(USER_NAME, PASSWORD);
        productsPage.clickAddToCartButton(SAUCE_LABS_ONESIE);
        headerPage.shoppingCartButtonClick();
        shoppingCartPage.clickCheckoutButton();
        checkoutPage.setFirstNameInput(CHECKOUT_FIRST_NAME);
        checkoutPage.setLastNameInput(CHECKOUT_LAST_NAME);
        checkoutPage.clickContinueButton();
        Assert.assertTrue(checkoutPage.isPostalCodeErrorMessageDisplayed());
    }
}
