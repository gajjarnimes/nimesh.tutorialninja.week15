package com.tutorialninja.demo.testsuite;

import com.sun.jna.WString;
import com.tutorialninja.demo.pages.MyAccount;
import com.tutorialninja.demo.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAccountTest extends Utility {
    MyAccount myAccount;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        myAccount = new MyAccount();
    }

    //**************************************MyAccount***************************************

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        myAccount.clickOnMyAccount();
        myAccount.selectMyAccountOptions("Register");
        Assert.assertEquals(myAccount.getVerifyRegister(), "Register Account", "Error Message not displayed");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        myAccount.clickOnMyAccount();
        myAccount.selectMyAccountOptions("Login");
        Assert.assertEquals(myAccount.getVerifyReturning(), "Returning Customer", "Error Message not displayed");
    }

    @Test(groups = "regression")
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        myAccount.clickOnMyAccount();
        myAccount.selectMyAccountOptions("Register");
        myAccount.enterPassword("Password65");
        myAccount.enterFirstName("Manan");
        myAccount.enterLastName("Shah");
        myAccount.enterEmailAdd("test12"+getAlphaNumericString(2)+"@gmail.com");
        myAccount.enterPhone("Password65");
        myAccount.enterPassword("020123456");
        myAccount.enterConfirmPass("020123456");
        myAccount.clickYesOnNewsLetter();
        myAccount.clickOnPrivacy();
        myAccount.clickFinalContinue();
        Assert.assertEquals(myAccount.getVerifyMessage(), "Register Account", "Error Message not displayed");
        myAccount.clickOnMyAccountTab();
        myAccount.selectMyAccountOptions("Logout");

    }

    private String getAlphaNumericString(int i) {
        getRandomString(2);
        return null;
    }


    @Test(groups = "regression")
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        myAccount.clickOnMyAccountTab();
        myAccount.selectMyAccountOptions("Login");
        myAccount.enterEmailAdd("test123499@gmail.com");
        myAccount.enterPassword("Password65");
        myAccount.selectMyAccountOptions("Logout");
        myAccount.clickOnContinueTab();
    }
}
