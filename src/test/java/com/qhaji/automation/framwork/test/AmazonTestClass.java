package com.qhaji.automation.framwork.test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AmazonTestClass
{

private WebDriver driver;


    @BeforeClass
    private void setUp()
    {
      System.setProperty("webdriver.chrome.driver","C:\\Users\\Sinawo Jackson\\Downloads\\chromedriver_win32\\chromedriver.exe");
      driver = new ChromeDriver();
    }

    @BeforeMethod

    public  void amazonUrl()
    {
        driver.get("http://www.amazon.com");

    }



    @AfterClass
    private  void  tearDown()
    {
        driver.quit();
    }

    @Test
    public void testAddingItemToCard()
    {

        //TODO
        //Test

        new Select(driver.findElement(By.id("searchDropdownBox"))).selectByVisibleText("Books");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Selenium");


        driver.findElement(By.xpath("//*[@value='Go']")).click();



        /*
        Click the first search result item title – In below code we are doing three things.
        Firstly we create local variable for item title element founded by its class name.
        Secondly we save item title text to local string variable so we can use it further.
        And lastly we click on item title element.
         */

        WebElement firstItemTitleElement = driver.findElement(By.className("s-access-title"));
        String firstItemTitle = firstItemTitleElement.getText();
        firstItemTitleElement.click();

        /*
        Verify that product title is correct – Now it is time for the first assertion.
        Assertion expects that given statement returns true. Otherwise it cause the test to fail.
        We want to verify that the product title on product details page is equal to variable from previous step 5.
        */

        assert (driver.findElement(By.id("productTitle")).getText().equals(firstItemTitle));


        //Click “Add to Cart” button

        driver.findElement(By.id("add-to-cart-button")).click();

        //Verify confirmation test appears: “1 item added to Cart”
       // assert (driver.findElement(By.id("hlb-ptc-btn-native")).getText().equals("Proceed to checkout"));







    }

}
