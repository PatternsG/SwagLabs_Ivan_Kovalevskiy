package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCartTests extends BaseTests{

    @Test
    public void removeProductsShoppingCartPositiveTest(){
        loginPage.initialization(USER_NAME, PASSWORD);
        productsPage.clickAddToCartButton(SAUCE_LABS_BACKPACK);
        productsPage.clickAddToCartButton(SAUCE_LABS_FLEECE_JACKET);
        headerPage.shoppingCartButtonClick();
        shoppingCartPage.clickRemoveButton(SAUCE_LABS_FLEECE_JACKET);
        Assert.assertEquals(shoppingCartPage.sizeOfCartItemContainer(), 1);
        Assert.assertEquals(shoppingCartPage.getItemName(), SAUCE_LABS_BACKPACK);
    }

    @Test
    public void continueShoppingButtonPositiveTest(){
        loginPage.initialization(USER_NAME, PASSWORD);
        productsPage.clickAddToCartButton(SAUCE_LABS_BACKPACK);
        headerPage.shoppingCartButtonClick();
        shoppingCartPage.clickContinueShoppingButton();
        Assert.assertTrue(productsPage.isHomePageHeaderDisplayed());
    }
}
