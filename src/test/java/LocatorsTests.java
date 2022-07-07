import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class LocatorsTests {

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

    @AfterMethod
    public void quit(){
        driver.quit();
    }

    @Test
    public void xpathTest(){
        WebElement userName = driver.findElement(By.xpath("//input[@name = 'user-name']"));
        userName.sendKeys("standard_user");
        WebElement password = driver.findElement(By.xpath("//input[contains(@name,'passwo')]"));
        password.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement
                (By.xpath("//input[@name ='login-button' and @value = 'Login']"));
        loginButton.click();
        WebElement backpack = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        backpack.click();
        WebElement back = driver.findElement
                (By.xpath("//button[@name = 'back-to-products']//parent::div"));
        back.click();
        WebElement bikeLight = driver.findElement
                (By.xpath("//a[@id = 'item_0_title_link']//descendant::div"));
        bikeLight.click();
        WebElement addButton = driver.findElement
                (By.xpath("//div[@class='inventory_details_price']//following-sibling::button"));
        addButton.click();
    }

    @Test
    public void cssSelector(){
        WebElement userName = driver.findElement(By.cssSelector("[name=user-name]"));
        userName.sendKeys("standard_user");
        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.cssSelector(".submit-button.btn_action"));
        loginButton.click();
        WebElement dropDownElements = driver.findElement(By.cssSelector("select"));
        Select select = new Select(dropDownElements);
        List <WebElement> nameAZ = select.getOptions();
        WebElement zToA = nameAZ.get(1);
        zToA.click();
        WebElement twitter = driver.findElement(By.cssSelector("[href*='twitter']"));
        twitter.click();
    }
}
