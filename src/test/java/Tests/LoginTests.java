package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests{

    @Test
    public void positiveLoginTest(){
        loginPage.initialization(USER_NAME,PASSWORD);
        Assert.assertTrue(productsPage.isHomePageHeaderDisplayed());
    }

    @Test
    public void negativeLoginTest(){
        loginPage.getUserName(USER_NAME);
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
    }


}
