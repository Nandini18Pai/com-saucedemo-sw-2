package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        //   Enter “standard_user” username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //   Enter “secret_sauce” password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //    Click on ‘LOGIN’ button
        driver.findElement(By.id("login-button")).click();
        //   Verify the text “PRODUCTS”
        String expectedText="Products";
        String actualText=driver.findElement(By.xpath("//span[text()='Products']")).getText();
        Assert.assertEquals(expectedText,actualText);
    }

    @Test

        public void verifyThatSixProductsAreDisplayedOnPage(){
        //   Enter “standard_user” username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //   Enter “secret_sauce” password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //    Click on ‘LOGIN’ button
        driver.findElement(By.id("login-button")).click();
        //Verify that six products are displayed on page
        List<WebElement> productList = driver.findElements(By.className("inventory_item"));
        System.out.println("Total Product: " + productList.size());
        // Verify the number of products are 6
        int expectSize = 6;
        int actualSize = productList.size();
        Assert.assertEquals(expectSize,actualSize);



    }
    @After
    public void tearDown() {
        closeBrowser();
    }

}
