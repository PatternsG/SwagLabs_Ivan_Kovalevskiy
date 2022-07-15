package Tests;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTests {

    final String USER_NAME = "standard_user";
    final String PASSWORD = "secret_sauce";

    final String SAUCE_LABS_BACKPACK = "Sauce Labs Backpack";
    final String SAUCE_LABS_BIKE_LIGHT = "Sauce Labs Bike Light";
    final String SAUCE_LABS_FLEECE_JACKET = "Sauce Labs Fleece Jacket";

    protected WebDriver driver;

    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected HeaderPage headerPage;
    protected ShoppingCartPage shoppingCartPage;
    protected ItemDetailsPage itemDetailsPage;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        headerPage = new HeaderPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        itemDetailsPage = new ItemDetailsPage(driver);
    }

    @BeforeMethod
    public void navigate(){
        driver.get("https://www.saucedemo.com/");
    }

    @AfterClass
    public void quit(){
        driver.quit();
    }
}
