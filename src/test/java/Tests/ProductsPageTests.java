package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsPageTests extends BaseTests {

    @Test(description = "Checking the addition of goods to the cart",
            groups = {"smoke"})
    public void addToShoppingCartPositiveTest(){
        loginPage.initialization(USER_NAME, PASSWORD);
        productsPage.clickAddToCartButton(SAUCE_LABS_BACKPACK);
        Assert.assertEquals(headerPage.getNumberOfItemsInTheCart(), "1",
                "Shopping cart icon not working properly");
        headerPage.shoppingCartButtonClick();
        Assert.assertEquals(shoppingCartPage.getItemName(), SAUCE_LABS_BACKPACK,
                "Wrong item added");
    }

    @Test(description = "Checking if items have been removed from the shopping cart",
            groups = {"smoke"})
    public void removeToShoppingCartPositiveTest() {
        loginPage.initialization(USER_NAME, PASSWORD);
        productsPage.clickAddToCartButton(SAUCE_LABS_BACKPACK);
        productsPage.clickAddToCartButton(SAUCE_LABS_BIKE_LIGHT);
        productsPage.clickAddToCartButton(SAUCE_LABS_FLEECE_JACKET);
        productsPage.clickRemoveToCartButton(SAUCE_LABS_BACKPACK);
        Assert.assertEquals(headerPage.getNumberOfItemsInTheCart(), "2",
                "Shopping cart icon not working properly");
    }

    @Test(description = "Sorting check",
            groups = {"smoke"})
    public void productsSortContainerPositiveTest() {
        loginPage.initialization(USER_NAME, PASSWORD);
        productsPage.clickChoiceSortContainer(3);
        productsPage.clickInventoryItemDescription();
        Assert.assertEquals(itemDetailsPage.getProductName(), SAUCE_LABS_FLEECE_JACKET);
    }

    @Test(description = "Check sorting by name",
            groups = {"regression"})
    public void productsSortContainerByNameZtoA() {
        loginPage.initialization(USER_NAME, PASSWORD);
        productsPage.clickChoiceSortContainer(1);
        Assert.assertEquals(productsPage.getCollectionProductsByIndex(0), T_SHIRT);
        Assert.assertEquals(productsPage.getCollectionProductsByIndex(5), SAUCE_LABS_BACKPACK);
    }

    @Test(description = "Check sorting by price",
            groups = {"regression"})
    public void productsSortContainerByPriceHighToLow() {
        loginPage.initialization(USER_NAME, PASSWORD);
        productsPage.clickChoiceSortContainer(3);
        Assert.assertEquals(productsPage.getCollectionPricesSort(), productsPage.getCollectionPrices());
    }
}
