package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsPageTests extends BaseTests{

    @Test
    public void addToShoppingCartPositiveTest(){
        loginPage.initialization(USER_NAME,PASSWORD);
        productsPage.clickAddToCartButton(SAUCE_LABS_BACKPACK);
        Assert.assertEquals(headerPage.numberOfItemsInTheCart(), "1",
                "Shopping cart icon not working properly");
        headerPage.shoppingCartButtonClick();
        Assert.assertEquals(shoppingCartPage.getItemName(), SAUCE_LABS_BACKPACK,
                "Wrong item added");
    }

    @Test
    public void removeToShoppingCartPositiveTest(){
        loginPage.initialization(USER_NAME, PASSWORD);
        productsPage.clickAddToCartButton(SAUCE_LABS_BACKPACK);
        productsPage.clickAddToCartButton(SAUCE_LABS_BIKE_LIGHT);
        productsPage.clickAddToCartButton(SAUCE_LABS_FLEECE_JACKET);
        productsPage.clickRemoveToCartButton(SAUCE_LABS_BACKPACK);
        Assert.assertEquals(headerPage.numberOfItemsInTheCart(), "2",
                "Shopping cart icon not working properly");
    }

    @Test
    public void productsSortContainerPositiveTest() {
        loginPage.initialization(USER_NAME, PASSWORD);
        productsPage.choiceSortContainer(3);
        productsPage.clickInventoryItemDescription();
        Assert.assertEquals(itemDetailsPage.getProductName(), SAUCE_LABS_FLEECE_JACKET);

    }
}
