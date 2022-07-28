package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCartTests extends BaseTests{

    @Test(description = "Checking if items have been removed from the shopping cart",
            groups = {"smoke"})
    public void removeProductsShoppingCartPositiveTest(){
        loginPage.initialization(USER_NAME, PASSWORD);
        productsPage.clickAddToCartButton(SAUCE_LABS_BACKPACK);
        productsPage.clickAddToCartButton(SAUCE_LABS_FLEECE_JACKET);
        headerPage.shoppingCartButtonClick();
        shoppingCartPage.clickRemoveButton(SAUCE_LABS_FLEECE_JACKET);
        Assert.assertEquals(shoppingCartPage.sizeOfCartItemContainer(), 1);
        Assert.assertEquals(shoppingCartPage.getItemName(), SAUCE_LABS_BACKPACK);
    }

    @Test(description = "Switching from the shopping cart to Products page",
            groups = {"smoke"})
    public void continueShoppingButtonPositiveTest() {
        loginPage.initialization(USER_NAME, PASSWORD);
        productsPage.clickAddToCartButton(SAUCE_LABS_BACKPACK);
        headerPage.shoppingCartButtonClick();
        shoppingCartPage.clickContinueShoppingButton();
        Assert.assertTrue(productsPage.isHomePageHeaderDisplayed());
    }
}
