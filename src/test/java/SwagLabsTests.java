import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class SwagLabsTests {

    private WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void input(){
        driver.get("https://www.saucedemo.com/");
    }

    @AfterClass
    public void quit(){
        driver.quit();
    }

    @Test
    public void swagLabTest(){

        WebElement userName = driver.findElement(By.cssSelector("#user-name"));
        userName.sendKeys("standard_user");
        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.cssSelector(".submit-button.btn_action"));
        loginButton.click();
        WebElement addToCart = driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack"));
        addToCart.click();
        WebElement shoppingCart = driver.findElement(By.cssSelector(".shopping_cart_link"));
        shoppingCart.click();
        WebElement productName = driver.findElement(By.cssSelector(".inventory_item_name"));
        WebElement productPrice = driver.findElement(By.cssSelector(".inventory_item_price"));
        Assert.assertEquals(productName.getText(), "Sauce Labs Backpack",
                "Name is incorrect");
        Assert.assertEquals(productPrice.getText(), "$29.99",
                "The price is incorrect");
        System.out.println(productName.getText());
        System.out.println(productPrice.getText());
    }

}
