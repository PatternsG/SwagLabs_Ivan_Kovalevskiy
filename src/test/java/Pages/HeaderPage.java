package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePage{

    private By menuButton = By.cssSelector("#react-burger-menu-btn");
    private By allItemsButton = By.cssSelector("#inventory_sidebar_link");
    private By aboutButton = By.cssSelector("#about_sidebar_link");
    private By logoutButton = By.cssSelector("#logout_sidebar_link");
    private By resetAppStateButton = By.cssSelector("#reset_sidebar_link");
    private By shoppingCartButton = By.cssSelector(".shopping_cart_link");
    private final By itemsInTheCart = By.cssSelector(".shopping_cart_badge");

    public HeaderPage(WebDriver driver){
        super(driver);
    }

    public void menuButtonClick(){
        driver.findElement(menuButton).click();
    }

    public void allItemsButtonClick(){
        driver.findElement(allItemsButton).click();
    }
    public void aboutButtonClick(){
        driver.findElement(aboutButton).click();
    }
    public void logoutButtonClick(){
        driver.findElement(logoutButton).click();
    }
    public void resetAppStateButtonClick(){
        driver.findElement(resetAppStateButton).click();
    }
    public void shoppingCartButtonClick(){
        driver.findElement(shoppingCartButton).click();
    }

    public String getNumberOfItemsInTheCart(){
        return driver.findElement(itemsInTheCart).getText();
    }

}
