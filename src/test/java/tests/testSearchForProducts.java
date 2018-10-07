package tests;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import support.Generator;
import support.Screenshot;

public class testSearchForProducts {
    private WebDriver mybrowser;
    private String directory_path;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
        directory_path = System.getProperty("user.dir") + "/reports/" + Generator.dateHourNow() + ".png";
        mybrowser = new ChromeDriver();
        mybrowser.get("http://automationpractice.com");
        mybrowser.manage().window().maximize();
    }

    @Test
    public void testSearchForValidProduct() {
        WebElement product = new HomePage(mybrowser).search("shirt")
                .firstProductResult();
        Assert.assertNotNull(product);
    }

    @After
    public void tearDown(){
        Screenshot.take(mybrowser, directory_path);
        mybrowser.quit();
    }
}
