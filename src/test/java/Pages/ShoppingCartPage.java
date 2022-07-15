package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ShoppingCartPage extends  HeaderPage{

    private final String removeButtonLocator =
            "//div[text()='%s']/ancestor::div[@class='cart_item_label']";
    private final By continueShoppingButton = By.cssSelector("#continue-shopping");
    private final By removeButton = By.cssSelector("button[id^='remove']");
    private final By checkoutButton = By.cssSelector("#checkout");
    private final By itemName = By.cssSelector(".inventory_item_name");
    private final By cartItem = By.cssSelector(".cart_item");

    public ShoppingCartPage (WebDriver driver){
        super(driver);
    }

    public void clickContinueShoppingButton(){
        driver.findElement(continueShoppingButton).click();
    }

    public void clickCheckoutButton(){
        driver.findElement(checkoutButton).click();
    }

    public String getItemName(){
        return driver.findElement(itemName).getText();
    }

    public void clickRemoveButton(String productName){
        WebElement product = getRemoveProductsByName(productName);
        product.findElement(removeButton).click();
    }

    public int sizeOfCartItemContainer(){
        List<WebElement> size = driver.findElements(cartItem);
        return size.size();
    }

    private WebElement getRemoveProductsByName(String productName){
        return driver.findElement(By.xpath(String.format(removeButtonLocator, productName)));
    }
}
