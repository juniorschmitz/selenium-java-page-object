package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver browser) {
        super(browser);
    }

    public MyAccountPage login(String email, String password){
        browser.findElement(By.id("email")).sendKeys(email);
        browser.findElement(By.cssSelector("input[name=\"passwd\"]")).sendKeys(password);
        browser.findElement(By.id("SubmitLogin")).click();
        return new MyAccountPage(browser);
    }
}
