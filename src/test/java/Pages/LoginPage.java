package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private By userNameInput = By.cssSelector("#user-name");
    private By passwordInput = By.cssSelector("#password");
    private By loginButton = By.cssSelector("#login-button");
    private By errorMessage = By.xpath("//h3[@data-test='error']");

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void getUserName (String userName) {
        driver.findElement(userNameInput).sendKeys(userName);
    }

    public void getPasswordInput (String password){
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton (){
        driver.findElement(loginButton).click();
    }

    public boolean isErrorMessageDisplayed(){
        return driver.findElement(errorMessage).isDisplayed();
    }

    public String getErrorMessageText (){
        return driver.findElement(errorMessage).getText();
    }

    public void initialization(String name, String password){
        getUserName(name);
        getPasswordInput(password);
        clickLoginButton();
    }
}
