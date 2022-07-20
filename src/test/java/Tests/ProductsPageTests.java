package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsPageTests extends BaseTests {

    @Test
    public void addToShoppingCartPositiveTest() {
        loginPage.initialization(USER_NAME, PASSWORD);
        productsPage.clickAddToCartButton(SAUCE_LABS_BACKPACK);
        Assert.assertEquals(headerPage.getNumberOfItemsInTheCart(), "1",
                "Shopping cart icon not working properly");
        headerPage.shoppingCartButtonClick();
        Assert.assertEquals(shoppingCartPage.getItemName(), SAUCE_LABS_BACKPACK,
                "Wrong item added");
    }

    @Test
    public void removeToShoppingCartPositiveTest() {
        loginPage.initialization(USER_NAME, PASSWORD);
        productsPage.clickAddToCartButton(SAUCE_LABS_BACKPACK);
        productsPage.clickAddToCartButton(SAUCE_LABS_BIKE_LIGHT);
        productsPage.clickAddToCartButton(SAUCE_LABS_FLEECE_JACKET);
        productsPage.clickRemoveToCartButton(SAUCE_LABS_BACKPACK);
        Assert.assertEquals(headerPage.getNumberOfItemsInTheCart(), "2",
                "Shopping cart icon not working properly");
    }

    @Test
    public void productsSortContainerPositiveTest() {
        loginPage.initialization(USER_NAME, PASSWORD);
        productsPage.clickChoiceSortContainer(3);
        productsPage.clickInventoryItemDescription();
        Assert.assertEquals(itemDetailsPage.getProductName(), SAUCE_LABS_FLEECE_JACKET);
    }

    @Test
    public void productsSortContainerByNameZtoA() {
        loginPage.initialization(USER_NAME, PASSWORD);
        productsPage.clickChoiceSortContainer(1);
        Assert.assertEquals(productsPage.getCollectionProductsByIndex(0), T_SHIRT);
        Assert.assertEquals(productsPage.getCollectionProductsByIndex(5), SAUCE_LABS_BACKPACK);
    }

    @Test
    public void productsSortContainerByPriceHighToLow() {
        loginPage.initialization(USER_NAME, PASSWORD);
        productsPage.clickChoiceSortContainer(3);
        Assert.assertEquals(productsPage.getCollectionPricesSort(), productsPage.getCollectionPrices());
    }
}
