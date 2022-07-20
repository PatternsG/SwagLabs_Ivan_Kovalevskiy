package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.*;
import java.util.stream.Collectors;

public class ProductsPage extends HeaderPage {

    private final String productContainerLocator =
            "//div[@class='inventory_item_name' and text() = '%s']/ ancestor::div[@class= 'inventory_item']";
    private final By addToCartButton = By.cssSelector("button[id^=add-to-cart]");
    private final By removeToCartButton = By.cssSelector("button[data-test*='remove']");
    private final By homePageHeader = By.id("header_container");
    private final By price = By.cssSelector(".inventory_item_price");
    private final By productSortContainer = By.cssSelector(".product_sort_container");
    private final By inventoryItemName = By.cssSelector(
            ".inventory_item_name");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isHomePageHeaderDisplayed() {
        return driver.findElement(homePageHeader).isDisplayed();
    }

    public void clickAddToCartButton(String productName) {
        WebElement productContainer = getProductContainerByName(productName);
        productContainer.findElement(addToCartButton).click();
    }

    public void clickRemoveToCartButton(String productName) {
        WebElement productContainer = getProductContainerByName(productName);
        productContainer.findElement(removeToCartButton).click();
    }


    private WebElement getProductContainerByName(String productName) {
        return driver.findElement(By.xpath(String.format(productContainerLocator, productName)));
    }

    public void clickChoiceSortContainer(int indexCollection) {
        WebElement sortContainer = driver.findElement(productSortContainer);
        Select select = new Select(sortContainer);
        List<WebElement> sort = select.getOptions();
        WebElement indexSort = sort.get(indexCollection);
        indexSort.click();
    }

    public void clickInventoryItemDescription() {
        driver.findElement(inventoryItemName).click();
    }


    public List<Double> getCollectionPricesSort() {
        List<WebElement> collectionProducts = driver.findElements(price);
        List<String> stringCollection = new ArrayList<>();
        for (WebElement collectionProduct : collectionProducts) {
            stringCollection.add(collectionProduct.getText().substring(1));
        }
        List<Double> doubleList = stringCollection.stream().map(Double::parseDouble).toList();
        return doubleList.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
    }

    public List<Double> getCollectionPrices() {
        List<WebElement> collectionProducts = driver.findElements(price);
        List<String> stringCollection = new ArrayList<>();
        for (WebElement collectionProduct : collectionProducts) {
            stringCollection.add(collectionProduct.getText().substring(1));
        }
        return stringCollection.stream().map(Double::parseDouble).collect(Collectors.toList());
    }

    public String getCollectionProductsByIndex(int index) {
        List<WebElement> collectionProducts = driver.findElements(inventoryItemName);
        return collectionProducts.get(index).getText();
    }
}
