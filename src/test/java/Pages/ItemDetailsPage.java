package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemDetailsPage extends HeaderPage{

    private final By productName = By.cssSelector(".inventory_details_name.large_size");
    private final By backToProductsButton = By.cssSelector("#back-to-products");
    private final By addToCartButton = By.cssSelector("#add-to-cart-sauce-labs-backpack");

    public ItemDetailsPage(WebDriver driver){
        super(driver);
    }

    public void setBackToProductsButton(){
        driver.findElement(backToProductsButton).click();
    }

    public void setAddToCartButton(){
        driver.findElement(addToCartButton).click();
    }

    public String getProductName(){
        return driver.findElement(productName).getText();
    }


}
