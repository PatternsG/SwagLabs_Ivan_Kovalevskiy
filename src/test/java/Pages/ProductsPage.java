package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends HeaderPage{

    private String productContainerLocator =
            "//div[@class='inventory_item_name' and text() = '%s']/ ancestor::div[@class= 'inventory_item']";
    private By addToCartButton = By.cssSelector("button[id^=add-to-cart]");
    private By removeToCartButton = By.cssSelector("button[data-test*='remove']");
    private  final By productLink = By.cssSelector("a[id*=_link]");
    private final By homePageHeader = By.id("header_container");
    private final By price = By.cssSelector(".inventory_item_price");
    private final By productSortContainer = By.cssSelector(".product_sort_container");
    private final By inventoryItemDescription = By.xpath
            ("//div[@class='inventory_item']/div/div/a/div[@class='inventory_item_name']");

    public ProductsPage(WebDriver driver){
        super(driver);
    }

    public boolean isHomePageHeaderDisplayed(){
        return driver.findElement(homePageHeader).isDisplayed();
    }

    public void clickAddToCartButton(String productName){
        WebElement productContainer = getProductContainerByName(productName);
        productContainer.findElement(addToCartButton).click();
    }
    public void clickRemoveToCartButton(String productName){
        WebElement productContainer = getProductContainerByName(productName);
        productContainer.findElement(removeToCartButton).click();
    }


    public String getProductPrice(String productsPrice){
        WebElement productContainer = getProductContainerByName(productsPrice);
        return productContainer.findElement(price).getText();
    }

    public void openItemByName(String productName){
        WebElement productContainer = getProductContainerByName(productName);
        productContainer.findElement(productLink).click();
    }

    private WebElement getProductContainerByName(String productName){
        return driver.findElement(By.xpath(String.format(productContainerLocator, productName)));
    }

    public void choiceSortContainer(int indexCollection){
        WebElement sortContainer = driver.findElement(productSortContainer);
        Select select = new Select(sortContainer);
        List<WebElement> sort = select.getOptions();
        WebElement indexSort = sort.get(indexCollection);
        indexSort.click();
    }

    public void clickInventoryItemDescription(){
        driver.findElement(inventoryItemDescription).click();
    }


}
