package Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests {

    @Test(description = "Check for logging", groups = {"smoke"})
    public void positiveLoginTest() {
        loginPage.initialization(USER_NAME, PASSWORD);
        Assert.assertTrue(productsPage.isHomePageHeaderDisplayed());
    }

    @Test(description = "Negative checking for logging without entering a password",
            groups = {"negative", "regression"})
    public void negativeLoginTest() {
        loginPage.getUserName(USER_NAME);
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
    }

    @Test(description = "Checking for logging with the input of various information",
            dataProvider = "dataProvider", groups = {"negative", "regression"})
    public void negativeLoginInputTest(String userName, String password, String errorMessage) {
        loginPage.getUserName(userName);
        loginPage.getPasswordInput(password);
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorMessageText(), errorMessage);
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
    }

    @DataProvider(name = "dataProvider")
    public Object[][] negativeLoginTestData() {
        return new Object[][]{
                {"name", PASSWORD, "Epic sadface: Username and password do not match any user in this service"},
                {USER_NAME, "", "Epic sadface: Password is required"},
                {"", PASSWORD, "Epic sadface: Username is required"}
        };
    }
}
