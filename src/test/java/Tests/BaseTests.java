package Tests;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


public class BaseTests {

    final String USER_NAME = "standard_user";
    final String PASSWORD = "secret_sauce";
    final String SAUCE_LABS_ONESIE = "Sauce Labs Onesie";
    final String T_SHIRT = "Test.allTheThings() T-Shirt (Red)";
    final String SAUCE_LABS_BACKPACK = "Sauce Labs Backpack";
    final String SAUCE_LABS_BIKE_LIGHT = "Sauce Labs Bike Light";
    final String SAUCE_LABS_FLEECE_JACKET = "Sauce Labs Fleece Jacket";
    final String CHECKOUT_FIRST_NAME = "Ivan";
    final String CHECKOUT_LAST_NAME = "Kovalevsky";
    final String CHECKOUT_POSTAL_CODE = "123456";

    protected WebDriver driver;

    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected HeaderPage headerPage;
    protected ShoppingCartPage shoppingCartPage;
    protected ItemDetailsPage itemDetailsPage;
    protected CheckoutPage checkoutPage;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        headerPage = new HeaderPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        itemDetailsPage = new ItemDetailsPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @BeforeMethod(alwaysRun = true)
    public void navigate() {
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod(alwaysRun = true)
    public void clearCookies() {
        driver.manage().deleteAllCookies();
        ((JavascriptExecutor) driver).executeScript(String.format("window.localStorage.clear();"));
        ((JavascriptExecutor) driver).executeScript(String.format("window.sessionStorage.clear();"));
    }

    @AfterClass(alwaysRun = true)
    public void quit() {
        driver.quit();
    }
}
