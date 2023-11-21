package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Write the test for ForgotPassword functionality
 * With  this method name userShouldNavigateToForgotPasswordPageSuccessfully
 *              * click on the ‘Forgot your password’ link
 *              * Verify the text ‘Reset Password’
 */



public class ForgotPasswordTest extends BaseTest {

    // Declare baseUrl
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    //Open Browser
    @Before
    public void setUP(){
        openBrowser(baseUrl);
    }

    @Test
    // Method name userShouldNavigateToForgotPasswordPageSuccessfully
    public void userShouldNavigateToForgotPasswordPageSuccessfully(){

        //Find Forgot your password link and click on the forgot your password
        WebElement passwordLink = driver.findElement(By.xpath("//p[contains(@class, 'oxd-text oxd-text--p orangehrm-login-forgot-header')]"));
        passwordLink.click();

        // Verify the text reset password
        // Expected text
        String expectedText = "Reset Password";

        // Actual text element find
        WebElement actualTextElement = driver.findElement(By.xpath("//h6[contains(@class, 'oxd-text oxd-text--h6 orangehrm-forgot-password-title')]"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals(expectedText, actualText);
    }

    // Close browser
    @After
    public void tearDown(){
        closeBrowser();
    }






}
