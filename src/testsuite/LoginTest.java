package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Write the test for Login functionality
 * With  this method name userShouldLoginSuccessfullyWithValidCredentials
 *              * Enter “Admin” username
 *              * Enter “admin123 password
 *              * Click on ‘LOGIN’ button
 *              * Verify the ‘Dashboard’ text is display
 */

public class LoginTest extends BaseTest {

    // Declare baseUrl
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    // open Browser
     @Before
    public void setUP() {
         openBrowser(baseUrl);
     }

    @Test
    // Method name userShouldLoginSuccessfullyWithValidCredentials
    public void userShouldLoginSuccessfullyWithValidCredentials(){

         // Find Username field and write username in the field
        WebElement userNameField = driver.findElement(By.name("username"));
        userNameField.sendKeys("Admin");

        // Find Password field and write password in the field
        WebElement passwordField = driver.findElement(By.xpath("//input[contains(@name, 'password')]"));
        passwordField.sendKeys("admin123");

        // Find Login button and click login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@type = 'submit']"));
        loginButton.click();

        // Expected result
        String expectedText = "Dashboard";

        // Actual result find and check equal or not
        WebElement actualTextElement = driver.findElement(By.xpath("//span[@class = 'oxd-topbar-header-breadcrumb']"));
        String actualText = actualTextElement.getText();

        // Verify expected and actual text
        Assert.assertEquals(expectedText, actualText);

    }

    @After
    // Close Browser
    public void tearDown(){
        closeBrowser();
    }
}
