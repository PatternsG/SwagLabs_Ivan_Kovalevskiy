package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTests {

    @Test
    public void checkoutInputTest() {
        loginPage.initialization(USER_NAME, PASSWORD);
        productsPage.clickAddToCartButton(SAUCE_LABS_BACKPACK);
        headerPage.shoppingCartButtonClick();
        shoppingCartPage.clickCheckoutButton();
        checkoutPage.setYourInformationInput();
        checkoutPage.clickContinueButton();
        Assert.assertTrue(checkoutPage.isOverviewTitleDisplayed());
    }

    @Test
    public void checkoutInputNegativeTest() {
        loginPage.initialization(USER_NAME, PASSWORD);
        productsPage.clickAddToCartButton(SAUCE_LABS_ONESIE);
        headerPage.shoppingCartButtonClick();
        shoppingCartPage.clickCheckoutButton();
        checkoutPage.setFirstNameInput();
        checkoutPage.setLastNameInput();
        checkoutPage.clickContinueButton();
        Assert.assertTrue(checkoutPage.isPostalCodeErrorMessageDisplayed());
    }
}
