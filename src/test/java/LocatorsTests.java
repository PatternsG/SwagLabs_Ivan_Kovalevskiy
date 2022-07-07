import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

    @Test
    public void xpathTest(){
        WebElement userName = driver.findElement(By.xpath("//input[@name = 'user-name']"));
        userName.sendKeys("123");
        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("1245");

    }
}
